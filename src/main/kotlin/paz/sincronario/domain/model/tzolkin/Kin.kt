package paz.sincronario.domain.model.tzolkin

import paz.sincronario.domain.enums.tzolkin.Seal
import paz.sincronario.domain.enums.tzolkin.Tone



data class Kin private constructor(
    val id: Int,
    val name: String,
    val seal: Seal,
    val tone: Tone,
    val guideKin: Int,
    val analogKin: Int,
    val hiddenKin: Int,
    val antipodeKin: Int,
    val poem: String
) {
    companion object {
        fun of(
            id: Int,
            seal: Seal,
            tone: Tone
        ): Kin {

            val kinName = buildKinName(seal, tone)
            val guideKinId = findGuideKinNumber(seal, tone)
            val guideSealAndTone = getSealAndToneFromKin(guideKinId)
            val analogKinId = findAnalogKinNumber(seal, tone)
            val antipodeKinId = findAntipodeKinNumber(seal, tone)
            val hiddenKinId = findHiddenKinNumber(seal, tone)
            val poemKin = buildPoem(seal, tone, guideSealAndTone.first)
            return Kin(id, kinName, seal, tone, guideKinId, analogKinId, hiddenKinId, antipodeKinId, poemKin)
        }
    }
}

fun buildTzolkin(): Map<Int, Kin> {
    val kins = mutableMapOf<Int, Kin>()
    var idKin = 1

    for (i in 0 until TZOLKIN_SIZE) {
        val seal = Seal.entries[i % Seal.entries.size] // 20 Selos
        val tone = Tone.entries[i % Tone.entries.size] // 13 Tons
        kins[idKin] = Kin.of(idKin, seal, tone)
        idKin++
    }

    return kins
}

internal fun calculateKinNumber(sealId: Int, toneId: Int): Int {
    val xValue = calculateX(sealId, toneId)
    val candidate = xValue * Seal.entries.size + sealId
    return if (candidate == TZOLKIN_SIZE) TZOLKIN_SIZE else candidate % TZOLKIN_SIZE
}

// X+1 is the number of the column the Kin is located within Tzolkin's matrix
internal fun calculateX(sealId: Int, toneId: Int): Int {
    val toneSize = Tone.entries.size
    val mysticNumber = 7
    validateWithinRange(sealId, toneId)
    val tomMod = toneId % Tone.entries.size

    for (k in 1..toneSize) {
        val x = ((tomMod + toneSize * k) - (sealId % toneSize)) / mysticNumber
        if (((sealId % toneSize) + x * mysticNumber) % toneSize == tomMod) {
            return x
        }
    }
    throw IllegalArgumentException("No value of x satisfies the equation for sealId: $sealId and toneId: $toneId.")
}

internal fun validateWithinRange(sealId: Int, toneId: Int) {
    validateSealRange(sealId)
    validateToneRange(toneId)
}

internal fun validateSealRange(sealId: Int) {
    require(sealId > 0 && sealId <= Seal.entries.size) { "$sealId not within Tzolkin's range for a Seal" }
}

internal fun validateToneRange(toneId: Int) {
    require(toneId > 0 && toneId <= Tone.entries.size) { "$toneId not within Tzolkin's range for a Tone" }
}

internal fun getSealAndToneFromKin(kinId: Int): Pair<Seal, Tone> {
    require(kinId > 0) { "KinId must be a positive integer" }

    val adjustedKinId = kinId - 1
    val sealIndex = adjustedKinId % Seal.entries.size
    val toneIndex = adjustedKinId % Tone.entries.size

    val seal = Seal.entries[sealIndex]
    val tone = Tone.entries[toneIndex]

    return seal to tone
}

internal fun buildKinName(seal: Seal, tone: Tone): String {
    return "${seal._name} ${tone._name} ${seal.color}"
}

internal fun buildPoem(seal: Seal, tone: Tone, guideSeal: Seal): String {
    var guideLine = "Eu sou guiado pelo poder da/o ${guideSeal.power}"
    if (seal == guideSeal) guideLine = "Sou guidado pelo meu próprio poder duplicado"
    return """Eu ${tone.power} com o fim de ${seal.action},
        ${tone.action} o/a ${seal.essence},
        Selo a/o ${seal.sealPoemWord} da/o ${seal.power},
        Com o tom ${tone._name}, da/o ${tone.essence},
        ${guideLine}
    """.trimIndent()
}

internal fun findGuideKinNumber(seal: Seal, tone: Tone): Int {
    val guideSealCalcResult = (seal.id + tone.hiddenSealAhead) % Seal.entries.size
    val guideSealId = if (guideSealCalcResult == 0) Seal.entries.size else guideSealCalcResult
    return calculateKinNumber(guideSealId, tone.id)
}

internal fun findAnalogKinNumber(seal: Seal, tone: Tone): Int {
    // Sum of pairs always is 19 (considering 20 = 0)
    val analogSealCalcResult = 19 - (seal.id % Seal.entries.size)
    val analogSealId = if (analogSealCalcResult == 0) Seal.entries.size else analogSealCalcResult
    return calculateKinNumber(analogSealId, tone.id)
}

internal fun findAntipodeKinNumber(seal: Seal, tone: Tone): Int {
    // Always 10 seals apart from each other (Seal.entries.size / 2)
    val antipodeSealCalcResult = (seal.id + 10) % Seal.entries.size
    val antipodeSealId = if (antipodeSealCalcResult == 0) Seal.entries.size else antipodeSealCalcResult
    return calculateKinNumber(antipodeSealId, tone.id)
}

internal fun findHiddenKinNumber(seal: Seal, tone: Tone): Int {
    // Sum of Seals always is (Seal.entries.size +1) and Sum of Tones always is (Tone.entries.size +1)
    val hiddenSealId = 21 - seal.id
    val hiddenToneId = 14 - tone.id
    return calculateKinNumber(hiddenSealId, hiddenToneId)
}
