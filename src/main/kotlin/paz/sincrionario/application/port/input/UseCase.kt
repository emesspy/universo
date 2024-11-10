package paz.sincrionario.application.port.input

interface UseCase {
    fun execute(input: String): String
}