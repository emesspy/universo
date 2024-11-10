package paz.sincrionario.application.port.output

import paz.sincrionario.domain.model.tzolkin.Kin

interface MyRepository {
    fun save(entity: Kin): Kin
    fun findById(id: Long): Kin?
}