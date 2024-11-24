package paz.sincronario.domain.enums.tzolkin

enum class Seal(
    val id: Int,
    val _name: String,
    val color: String,
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
    val sealPoemWord: String
) {
    DRAGON(1, "Dragão", "Vermelho", "Imix", "Nascimento", "Nutrir", "Ser", "Cardinal", "Fogo", "Leste", "Netuno", "Laríngeo", "A Força Primordial","Entrada"),
    WIND(2, "Vento", "Branco", "Ik", "Espírito", "Comunicar", "Alento", "Central", "Fogo", "Norte", "Urano", "Cardíaco", "A Suma Sacerdotisa","Entrada"),
    NIGHT(3, "Noite", "Azul", "Akbal", "Abundância", "Sonhar", "Intuição", "Sinal", "Fogo", "Oeste", "Saturno", "Plexo Solar", "O Sonhador","Entrada"),
    SEED(4, "Semente", "Amarelo", "Kan", "Florescimento", "Focalizar", "Percepção", "Portal", "Fogo", "Sul", "Júpiter", "Raiz", "O Inocente","Entrada"),
    SERPENT(5, "Serpente", "Vermelho", "Chicchan", "Força Vital", "Sobreviver", "Instinto", "Polar", "Sengue", "Leste", "Maldek", "Coronário", "O Iniciado da Serpente","Armazém"),
    WORLD_BRIDGER(6, "Enlaçador de Mundos", "Branco", "Cimi", "Morte", "Igualar", "Oportunidade", "Cardinal", "Sangue", "Norte", "Marte", "Laríngeo", "O Hierofante","Armazém"),
    HAND(7, "Mão", "Azul", "Manik", "Realização", "Conhecer", "Cura", "Central", "Sangue", "Oeste", "Terra", "Cardíaco", "O Avatar","Armazém"),
    STAR(8, "Estrela", "Amarelo", "Lamat", "Elegância", "Embelezar", "Arte", "Sinal", "Sangue", "Sul", "Vênus", "Plexo Solar", "O Artista","Armazém"),
    MOON(9, "Lua", "Vermelho", "Muluc", "Água Universal", "Purificar", "Fluxo", "Portal", "Sangue", "Leste", "Mercúrio", "Raiz", "A Curandeira","Precesso"),
    DOG(10, "Cachorro", "Branco", "Oc", "Coração", "Amar", "Lealdade", "Polar", "Verdade", "Norte", "Mercúrio", "Coronário", "O Compassivo","Precesso"),
    MONKEY(11, "Macaco", "Azul", "Chuen", "Magia", "Brincar", "Ilusão", "Cardinal", "Verdade", "Oeste", "Vênus", "Laríngeo", "O Ilusionista","Precesso"),
    HUMAN(12, "Humano", "Amarelo", "Eb", "Livre Arbítrio", "Influenciar", "Sabedoria", "Central", "Verdade", "Sul", "Terra", "Cardíaco", "O Sábio","Precesso"),
    SKY_WALKER(13, "Caminhante dos Céus", "Vermelho", "Ben", "Espaço", "Explorar", "Vigilância", "Sinal", "Verdade", "Leste", "Marte", "Plexo Solar", "O Profeta","Saída"),
    WIZARD(14, "Mago", "Branco", "Ix", "Intemporalidade", "Encantar", "Receptividade", "Portal", "Verdade", "Norte", "Maldek", "Raiz", "O Mago","Saída"),
    EAGLE(15, "Águia", "Azul", "Men", "Visão", "Criar", "Mente", "Polar", "Céu", "Oeste", "Júpiter", "Coronário", "O Vidente","Saída"),
    WARRIOR(16, "Guerreiro", "Amarelo", "Cib", "Inteligência", "Questionar", "Intrepidez", "Cardinal", "Céu", "Sul", "Saturno", "Laríngeo", "O Descobrido","Saída"),
    EARTH(17, "Terra", "Vermelho", "Caban", "Navegação", "Evoluir", "Sincronicidade", "Central", "Céu", "Leste", "Urano", "Cardíaco", "O Navegador","Matriz"),
    MIRROR(18, "Espelho", "Branco", "Etznab", "Infinito", "Refletir", "Ordem", "Sinal", "Céu", "Norte", "Netuno", "Plexo Solar", "Yogue/Yoguine","Matriz"),
    STORM(19, "Tormenta", "Azul", "Cauac", "Autogeração", "Catalisar", "Energia", "Portal", "Céu", "Oeste", "Plutão", "Raiz", "O Transformador de Mundos","Matriz"),
    SUN(20, "Sol", "Amarelo", "Ahau", "Fogo Universal", "Iluminar", "Vida", "Polar", "Fogo", "Sul", "Plutão", "Coronário", "O Iluminado","Matriz");
}