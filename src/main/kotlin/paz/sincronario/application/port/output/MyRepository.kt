package paz.sincronario.application.port.output

import paz.sincronario.domain.model.tzolkin.Kin

interface MyRepository {
    fun save(entity: Kin): Kin
    fun findById(id: Long): Kin?
}