package paz.sincronario.application.port.input

import paz.sincronario.domain.model.tzolkin.Kin
import paz.sincronario.domain.model.tzolkin.WaveSpell

typealias GetKin = (Int) -> Kin

typealias GetWaveSpell = (Int) -> WaveSpell

typealias GetWaveSpellByKin = (Kin) -> WaveSpell