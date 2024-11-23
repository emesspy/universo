package paz.sincrionario.application.service.tzolkin

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import paz.sincrionario.application.port.input.GetKin
import paz.sincrionario.domain.model.tzolkin.Tzolkin

@Service
class TzolkinService {
    val logger: Logger = LoggerFactory.getLogger(TzolkinService::class.java)

    val getKin: GetKin = { id: Int ->
        logger.info("Getting Kin $id...")
        val kin = Tzolkin.getKin(id)!!
        logger.info("Kin $id: $kin")
        kin
    }

}