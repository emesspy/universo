package paz.sincronario.infrastructure.adapter.output.persistence

import org.springframework.stereotype.Repository
import paz.sincronario.application.port.output.MyRepository
import paz.sincronario.domain.model.tzolkin.Kin

@Repository
class MyRepositoryImpl: MyRepository {
    override fun save(entity: Kin): Kin {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Kin? {
        TODO("Not yet implemented")
    }
}