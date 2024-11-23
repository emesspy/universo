package paz.sincrionario.domain.model.tzolkin

object Tzolkin {
    private val tzolkinMap = buildTzolkin()

    fun getKin(id: Int) = tzolkinMap[id]
}