package paz.sincrionario.infrastructure.adapter.input.rest

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import paz.sincrionario.application.port.input.UseCase

@Controller
class MyController(private val useCase: UseCase) {

    @GetMapping("/process")
    fun process(@RequestParam input: String): String {
        return useCase.execute(input);
    }
}