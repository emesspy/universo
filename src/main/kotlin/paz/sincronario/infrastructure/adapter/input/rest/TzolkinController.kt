package paz.sincronario.infrastructure.adapter.input.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import paz.sincronario.application.service.tzolkin.TzolkinService
import paz.sincronario.domain.model.tzolkin.Kin
import paz.sincronario.domain.model.tzolkin.WaveSpell

@RestController
class TzolkinController(private val tzolkinService: TzolkinService) {

    @GetMapping("/kin/{id}")
    fun getKin(@PathVariable id: Int): Kin {
        return tzolkinService.getKin(id)
    }

    @GetMapping("/wave-spell/{id}")
    fun getWaveSpell(@PathVariable id: Int): WaveSpell {
        return tzolkinService.getWaveSpell(id)
    }

    @GetMapping("/wave-spell/kin/{id}")
    fun getWaveSpellByKin(@PathVariable id: Int): WaveSpell {
        val kin = tzolkinService.getKin(id)
        return tzolkinService.getWaveSpellByKin(kin)
    }
}