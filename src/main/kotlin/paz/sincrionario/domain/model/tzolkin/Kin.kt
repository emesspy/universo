package paz.sincrionario.domain.model.tzolkin

data class Kin(
    val id: Int,
    val name: String,
    val seal: Seal,
    val tone: Tone,
    val guideKin: Kin?,
    val analogKin: Kin?,
    val hiddenKin: Kin?,
    val antipodeKin: Kin?
) {
}