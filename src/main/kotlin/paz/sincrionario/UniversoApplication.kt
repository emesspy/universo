package paz.sincrionario

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import paz.sincrionario.domain.model.tzolkin.buildTzolkin

@SpringBootApplication
class UniversoApplication

fun main(args: Array<String>) {
    runApplication<UniversoApplication>(*args)
    val tzolKin = buildTzolkin()
    println(tzolKin)
    println(tzolKin[86])
    println(tzolKin[37])
}
