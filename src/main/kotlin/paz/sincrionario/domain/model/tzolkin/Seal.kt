package paz.sincrionario.domain.model.tzolkin

data class Seal(
    val id: Int,
    val name: String,
    val mayaName: String,
    val power: String,
    val action: String,
    val essence: String,
    val family: String,
    val clan: String,
    val direction: String,
    val planet: String,
    val chakra: String,
    val archetype: String,
) {
}