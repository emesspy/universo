package paz.sincrionario.domain.model.tzolkin

import paz.sincrionario.domain.enums.tzolkin.Seal
import paz.sincrionario.domain.enums.tzolkin.Tone

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

    for (i in 0 until 260) {
        val seal = Seal.entries[i % Seal.entries.size] // 20 Selos
        val tone = Tone.entries[i % Tone.entries.size] // 13 Tons
        kins.put(idKin, Kin.of(idKin, seal, tone))
        idKin++
    }

    return kins
}

fun calculateKinNumber(sealId: Int, toneId: Int): Int {
    val xValue = calculateX(sealId, toneId)
    return xValue * 20 + (sealId % 20)
}

// X+1 is the number of the column the Kin is located within Tzolkin matrix
private fun calculateX(sealId: Int, toneId: Int): Int {
    val toneSize = Tone.entries.size
    val mysticNumber = 7
    val maxIterations = toneSize - 1

    for (k in 0..maxIterations) {
        val x = ((toneId + toneSize * k) - (sealId % toneSize)) / mysticNumber
        if (((sealId % toneSize) + x * mysticNumber) % toneSize == toneId) {
            return x
        }
        if (sealId == 20 && toneId == 13)
            return 12
    }
    throw IllegalArgumentException("No value of x satisfies the equation for sealId: $sealId and toneId: $toneId.")
}

private fun buildKinName(seal: Seal, tone: Tone): String {
    return "${seal._name} ${tone._name} ${seal.color}"
}

private fun findGuideKinNumber(seal: Seal, tone: Tone): Int {
    val guideSealCalcResult = (seal.id + tone.hiddenSealAhead) % Seal.entries.size
    val guideSealId = if (guideSealCalcResult == 0) 20 else guideSealCalcResult
    return calculateKinNumber(guideSealId, tone.id)
}

private fun findAnalogKinNumber(seal: Seal, tone: Tone): Int {
    val analogSealCalcResult = 19 - (seal.id % Seal.entries.size)
    val analogSealId = if (analogSealCalcResult == 0) 20 else analogSealCalcResult
    return calculateKinNumber(analogSealId, tone.id)
}

private fun findAntipodeKinNumber(seal: Seal, tone: Tone): Int {
    val antipodeSealCalcResult = (seal.id + 10) % Seal.entries.size
    val antipodeSealId = if (antipodeSealCalcResult == 0) 20 else antipodeSealCalcResult
    return calculateKinNumber(antipodeSealId, tone.id)
}

private fun findHiddenKinNumber(seal: Seal, tone: Tone): Int {
    val hiddenSealId = 21 - seal.id
    val hiddenToneId = 14 - tone.id
    return calculateKinNumber(hiddenSealId, hiddenToneId)
}
