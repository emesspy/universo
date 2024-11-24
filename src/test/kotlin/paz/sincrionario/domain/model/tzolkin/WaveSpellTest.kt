package paz.sincrionario.domain.model.tzolkin

import kotlin.test.Test
import kotlin.test.assertEquals

class WaveSpellTest {

    @Test
    fun `build all WaveSpells`() {
        val tzolkin = buildTzolkin()

        val (waveSpellMap, waveSpellReverseIndex) = buildAllWaveSpellsAndWaveSpellReverseIndex(tzolkin)
        println(waveSpellMap)

        assertEquals(WAVE_SPELL_SIZE, waveSpellMap.size)
        assertEquals(TZOLKIN_SIZE, waveSpellReverseIndex.size)
    }

    @Test
    fun `validate reverse index - Kin 86`() {
        val tzolkin = buildTzolkin()

        val (_, waveSpellReverseIndex) = buildAllWaveSpellsAndWaveSpellReverseIndex(tzolkin)
        val waveSpell = waveSpellReverseIndex[tzolkin[86]]
        println(waveSpell)

        assertEquals(7, waveSpell)
    }

    @Test
    fun `validate reverse index - Kin 37`() {
        val tzolkin = buildTzolkin()

        val (_, waveSpellReverseIndex) = buildAllWaveSpellsAndWaveSpellReverseIndex(tzolkin)
        val waveSpellId = waveSpellReverseIndex[tzolkin[37]]
        println(waveSpellId)

        assertEquals(3, waveSpellId)
    }
}