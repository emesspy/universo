package paz.sincrionario.application.service.tzolkin

import org.junit.jupiter.api.Test
import paz.sincrionario.domain.model.tzolkin.buildTzolkin
import kotlin.test.assertEquals

class TzolkinServiceTest {

    @Test
    fun `getKin - should return kin`() {
        val sut = TzolkinService()

        val tzolkin = buildTzolkin()

        for (i in 1..tzolkin.size)
            assertEquals(tzolkin[i], sut.getKin(i))
    }
}