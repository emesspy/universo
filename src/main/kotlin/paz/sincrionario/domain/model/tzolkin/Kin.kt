package paz.sincrionario.domain.model.tzolkin

import paz.sincrionario.domain.enums.tzolkin.Seal
import paz.sincrionario.domain.enums.tzolkin.Tone

// Tzolkin as 20x13=260 possibilities (Seal.entries.size x Tone.entries.size)
const val TZOLKIN_SIZE = 260

data class Kin private constructor(
    val id: Int,
    val name: String,
    val seal: Seal,
    val tone: Tone,
    val guideKin: Int,
    val analogKin: Int,
    val hiddenKin: Int,
    val antipodeKin: Int
) {
    companion object {
        fun of(
            id: Int,
            seal: Seal,
            tone: Tone
        ): Kin {

            val kinName = buildKinName(seal, tone)
            val guideKinId = findGuideKinNumber(seal, tone)
            val analogKinId = findAnalogKinNumber(seal, tone)
            val antipodeKinId = findAntipodeKinNumber(seal, tone)
            val hiddenKinId = findHiddenKinNumber(seal, tone)
            return Kin(id, kinName, seal, tone, guideKinId, analogKinId, hiddenKinId, antipodeKinId)
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

fun calculateKinNumber(sealId: Int, toneId: Int): Int {
    val xValue = calculateX(sealId, toneId)
    val candidate = xValue * Seal.entries.size + sealId
    return if (candidate == TZOLKIN_SIZE) TZOLKIN_SIZE else candidate % TZOLKIN_SIZE
}

// X+1 is the number of the column the Kin is located within Tzolkin's matrix
fun calculateX(sealId: Int, toneId: Int): Int {
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

fun validateWithinRange(sealId: Int, toneId: Int) {
    validateSealRange(sealId)
    validateToneRange(toneId)
}

fun validateSealRange(sealId: Int) {
    require(sealId > 0 && sealId <= Seal.entries.size) { "$sealId not within Tzolkin's range for a Seal" }
}

fun validateToneRange(toneId: Int) {
    require(toneId > 0 && toneId <= Tone.entries.size) { "$toneId not within Tzolkin's range for a Tone" }
}

fun buildKinName(seal: Seal, tone: Tone): String {
    return "${seal._name} ${tone._name} ${seal.color}"
}

fun findGuideKinNumber(seal: Seal, tone: Tone): Int {
    val guideSealCalcResult = (seal.id + tone.hiddenSealAhead) % Seal.entries.size
    val guideSealId = if (guideSealCalcResult == 0) Seal.entries.size else guideSealCalcResult
    return calculateKinNumber(guideSealId, tone.id)
}

fun findAnalogKinNumber(seal: Seal, tone: Tone): Int {
    // Sum of pairs always is 19 (considering 20 = 0)
    val analogSealCalcResult = 19 - (seal.id % Seal.entries.size)
    val analogSealId = if (analogSealCalcResult == 0) Seal.entries.size else analogSealCalcResult
    return calculateKinNumber(analogSealId, tone.id)
}

fun findAntipodeKinNumber(seal: Seal, tone: Tone): Int {
    // Always 10 seals apart from each other (Seal.entries.size / 2)
    val antipodeSealCalcResult = (seal.id + 10) % Seal.entries.size
    val antipodeSealId = if (antipodeSealCalcResult == 0) Seal.entries.size else antipodeSealCalcResult
    return calculateKinNumber(antipodeSealId, tone.id)
}

fun findHiddenKinNumber(seal: Seal, tone: Tone): Int {
    // Sum of Seals always is (Seal.entries.size +1) and Sum of Tones always is (Tone.entries.size +1)
    val hiddenSealId = 21 - seal.id
    val hiddenToneId = 14 - tone.id
    return calculateKinNumber(hiddenSealId, hiddenToneId)
}
