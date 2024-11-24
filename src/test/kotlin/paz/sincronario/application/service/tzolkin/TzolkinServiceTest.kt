package paz.sincronario.application.service.tzolkin

import org.junit.jupiter.api.Test
import paz.sincronario.domain.model.tzolkin.buildTzolkin
import kotlin.test.assertEquals

class TzolkinServiceTest {

    @Test
    fun `getKin - should return kin`() {
        val sut = TzolkinService()

        val tzolkin = buildTzolkin()

        for (i in 1..tzolkin.size)
            assertEquals(tzolkin[i], sut.getKin(i))
    }

    @Test
    fun `getWaveSpell - should return WaveSpell`() {
        val sut = TzolkinService()

        val waveSpell = sut.getWaveSpell(3)

        assertEquals(3, waveSpell.id)
    }

    @Test
    fun `getWaveSpellByKin - should return WaveSpell`() {
        val sut = TzolkinService()

        val tzolkin = buildTzolkin()
        val waveSpell = sut.getWaveSpellByKin(tzolkin[86]!!)

        assertEquals(7, waveSpell.id)
    }
}