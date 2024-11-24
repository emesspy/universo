package paz.sincrionario.domain.model.tzolkin

// There are 20 Wave Spells with 13 Kins
const val WAVE_SPELL_SIZE = 20
const val WAVE_SPELL_LENGTH = 13

data class WaveSpell private constructor(
    val id: Int,
    val kins: Map<Int, Kin>,
    val startKinId: Int,
    val endKinId: Int,
    val portalKinList: List<Int>
) {
    companion object {
        fun of(
            id: Int,
            tzolkinMap: Map<Int, Kin>,
            startKinId: Int,
            endKinId: Int
        ): WaveSpell {

            val kinMap = buildKinMap(tzolkinMap, startKinId, endKinId)

            return WaveSpell(id, kinMap, startKinId, endKinId, mutableListOf())
        }
    }
}

data class WaveSpellMaps(
    val waveSpellMap: Map<Int, WaveSpell>,
    val waveSpellReverseIndex: Map<Kin, Int>
)

fun buildAllWaveSpellsAndWaveSpellReverseIndex(tzolkinMap: Map<Int, Kin>): WaveSpellMaps {
    val waveSpells = mutableMapOf<Int, WaveSpell>()
    val waveSpellReverseIndex = mutableMapOf<Kin, Int>()
    var idWaveSpell = 1
    var startKin = 0
    var endKin: Int
    var endOfWaveSpell: Boolean

    for (i in 0 until TZOLKIN_SIZE) {
        endOfWaveSpell = false
        val kin = tzolkinMap[i + 1]!!
        if (1 == kin.tone.id)
            startKin = kin.id
        if (WAVE_SPELL_LENGTH == kin.tone.id) {
            endKin = kin.id
            waveSpells[idWaveSpell] = WaveSpell.of(idWaveSpell, tzolkinMap, startKin, endKin)
            endOfWaveSpell = true
        }
        waveSpellReverseIndex[kin] = idWaveSpell
        if (endOfWaveSpell) idWaveSpell++
    }

    return WaveSpellMaps(waveSpells, waveSpellReverseIndex)
}

internal fun buildKinMap(tzolkinMap: Map<Int, Kin>, startKinId: Int, endKinId: Int): Map<Int, Kin> {

    val kinMap = mutableMapOf<Int, Kin>()

    for (i in startKinId..endKinId) {
        kinMap[i] = tzolkinMap[i]!!
    }

    return kinMap
}