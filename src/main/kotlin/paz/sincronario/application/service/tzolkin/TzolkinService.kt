package paz.sincronario.application.service.tzolkin

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import paz.sincronario.application.port.input.GetKin
import paz.sincronario.application.port.input.GetWaveSpell
import paz.sincronario.application.port.input.GetWaveSpellByKin
import paz.sincronario.domain.model.tzolkin.Kin
import paz.sincronario.domain.model.tzolkin.Tzolkin

@Service
class TzolkinService {
    val logger: Logger = LoggerFactory.getLogger(TzolkinService::class.java)

    val getKin: GetKin = { id: Int ->
        logger.debug("Getting Kin $id...")
        val kin = Tzolkin.getKin(id)!!
        logger.trace("Kin $id: $kin")
        kin
    }

    val getWaveSpell: GetWaveSpell = { id: Int ->
        logger.debug("Getting WaveSpell $id...")
        val waveSpell = Tzolkin.getWaveSpell(id)!!
        logger.trace("WaveSpell $id: $waveSpell")
        waveSpell
    }

    val getWaveSpellByKin: GetWaveSpellByKin = { kin: Kin ->
        logger.debug("Getting WaveSpell by Kin ${kin.id}...")
        val waveSpellId = Tzolkin.getWaveSpell(kin)!!
        val waveSpell = Tzolkin.getWaveSpell(waveSpellId)!!
        logger.trace("Kin ${kin.id} is in WaveSpell $waveSpellId: $waveSpell")
        waveSpell
    }

}