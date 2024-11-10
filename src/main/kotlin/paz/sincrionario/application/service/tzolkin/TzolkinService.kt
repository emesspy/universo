package paz.sincrionario.application.service.tzolkin

import org.springframework.stereotype.Service
import paz.sincrionario.application.port.input.UseCase
import paz.sincrionario.application.port.output.MyRepository
import paz.sincrionario.domain.model.tzolkin.Kin

@Service
class TzolkinService(private val repository: MyRepository) : UseCase {
    override fun execute(input: String): String {
        //val kin = Kin()
        //val save = repository.save(kin)
        //return save.id.toString()
        return input;
    }
}