package paz.sincrionario.domain.model.tzolkin

import org.junit.jupiter.api.assertThrows
import paz.sincrionario.domain.enums.tzolkin.Seal
import paz.sincrionario.domain.enums.tzolkin.Tone
import kotlin.test.Test
import kotlin.test.assertEquals

class KinKtTest {

    @Test
    fun `calculateX with valid inputs`() {
        val sealId = 6
        val toneId = 8
        val result = calculateX(sealId, toneId)
        assertEquals(4, result, "Expected x to be 4 for sealId: $sealId and toneId: $toneId")
    }

    @Test
    fun `calculateX with Tone 13`() {
        val sealId = 6
        val toneId = 13
        val result = calculateX(sealId, toneId)
        assertEquals(1, result, "Expected x to be 1 for sealId: $sealId and toneId: $toneId")
    }

    @Test
    fun `calculateX with invalid seal`() {
        val sealId = 100
        val toneId = 13
        val exception = assertThrows<IllegalArgumentException> {
            calculateX(sealId, toneId)
        }
        assertEquals("$sealId not within Tzolkin's range for a Seal", exception.message)
    }

    @Test
    fun `calculateX with invalid tone`() {
        val sealId = 20
        val toneId = 14
        val exception = assertThrows<IllegalArgumentException> {
            calculateX(sealId, toneId)
        }
        assertEquals("$toneId not within Tzolkin's range for a Tone", exception.message)
    }

    @Test
    fun `findHiddenKinNumber Kin 1`() {
        val hiddenKinForKin1 = findHiddenKinNumber(Seal.DRAGON, Tone.MAGNETIC);
        assertEquals(260, hiddenKinForKin1)
    }

    @Test
    fun `findAnalogKinNumber Kin 3`() {
        val analogKinForKin3 = findAnalogKinNumber(Seal.NIGHT, Tone.ELECTRIC)
        assertEquals(16, analogKinForKin3)
    }
}