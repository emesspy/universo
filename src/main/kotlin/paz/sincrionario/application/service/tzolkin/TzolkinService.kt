package paz.sincrionario.application.service.tzolkin

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import paz.sincrionario.application.port.input.GetKin
import paz.sincrionario.application.port.input.GetWaveSpell
import paz.sincrionario.application.port.input.GetWaveSpellByKin
import paz.sincrionario.domain.model.tzolkin.Kin
import paz.sincrionario.domain.model.tzolkin.Tzolkin

@Service
class TzolkinService {
    val logger: Logger = LoggerFactory.getLogger(TzolkinService::class.java)

    val getKin: GetKin = { id: Int ->
        logger.debug("Getting Kin $id...")
        val kin = Tzolkin.getKin(id)!!
        logger.debug("Kin $id: $kin")
        kin
    }

    val getWaveSpell: GetWaveSpell = { id: Int ->
        logger.debug("Getting WaveSpell $id...")
        val waveSpell = Tzolkin.getWaveSpell(id)!!
        logger.debug("WaveSpell $id: $waveSpell")
        waveSpell
    }

    val getWaveSpellByKin: GetWaveSpellByKin = { kin: Kin ->
        logger.debug("Getting WaveSpell by Kin $kin...")
        val waveSpellId = Tzolkin.getWaveSpell(kin)!!
        val waveSpell = Tzolkin.getWaveSpell(waveSpellId)!!
        logger.debug("Kin ${kin.id} is in WaveSpell $waveSpellId: $waveSpell")
        waveSpell
    }

}