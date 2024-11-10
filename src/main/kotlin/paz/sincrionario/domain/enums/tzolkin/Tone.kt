package paz.sincrionario.domain.enums.tzolkin

enum class Tone(
    val id: Int,
    val _name: String,
    val mayaName: String,
    val power: String,
    val action: String,
    val essence: String,
    val hiddenSealAhead: Int
) {
    MAGNETIC(1, "Magnético", "Hun", "Unifica", "Atrai", "Propósito", 0),
    LUNAR(2, "Lunar", "Ca", "Polariza", "Estabiliza", "Desafio", 12),
    ELECTRIC(3, "Eléctrico", "Ox", "Ativa", "Vincula", "Serviço", 4),
    SELF_EXISTING(4, "Autoexistente", "Kan", "Define", "Mede", "Forma", 16),
    OVERTONE(5, "Harmônico", "Ho", "Potencializa", "Comanda", "Radiação", 8),
    RHYTHMIC(6, "Rítmico", "Uac", "Organiza", "Equilíbra", "Igualdade", 0),
    RESONANT(7, "Ressonante", "Uuc", "Canaliza", "Inspira", "Harmonização", 12),
    GALACTIC(8, "Galáctico", "Uaxac", "Harmoniza", "Modela", "Integridade", 4),
    SOLAR(9, "Solar", "Bolon", "Pulsa", "Realiza", "Intenção", 16),
    PLANETARY(10, "Planetário", "Lahun", "Aperfeiçoa", "Produz", "Manifestação", 8),
    SPECTRAL(11, "Espectral", "Buluc", "Dissolve", "Liberta", "Liberação", 0),
    CRYSTAL(12, "Cristal", "Lahac", "Dedica", "Universaliza", "Cooperação", 12),
    COSMIC(13, "Cósmico", "Oxlahun", "Persevera", "Transcende", "Presença", 4);
}