package paz.sincrionario.application.port.input

import paz.sincrionario.domain.model.tzolkin.Kin
import paz.sincrionario.domain.model.tzolkin.WaveSpell

typealias GetKin = (Int) -> Kin

typealias GetWaveSpell = (Int) -> WaveSpell

typealias GetWaveSpellByKin = (Kin) -> WaveSpell