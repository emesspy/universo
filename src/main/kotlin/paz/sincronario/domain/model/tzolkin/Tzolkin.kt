package paz.sincronario.domain.model.tzolkin

// Tzolkin as 20x13=260 possibilities (Seal.entries.size x Tone.entries.size)
const val TZOLKIN_SIZE = 260

object Tzolkin {
    private val tzolkinMap = buildTzolkin()
    private val waveSpellMaps = buildAllWaveSpellsAndWaveSpellReverseIndex(tzolkinMap)


    fun getKin(id: Int) = tzolkinMap[id]

    fun getWaveSpell(id: Int) = waveSpellMaps.waveSpellMap[id]

    fun getWaveSpell(kin: Kin) = waveSpellMaps.waveSpellReverseIndex[kin]
}