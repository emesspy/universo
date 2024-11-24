package paz.sincronario.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.web.filter.CommonsRequestLoggingFilter
import org.springframework.context.annotation.Configuration

@Configuration
class LoggingConfig {

    @Bean
    fun logFilter(): CommonsRequestLoggingFilter {
        val filter = CommonsRequestLoggingFilter()
        filter.setIncludeQueryString(true)
        filter.setIncludePayload(true)
        filter.setMaxPayloadLength(10000) // Tamanho máximo do payload
        filter.setIncludeHeaders(true)
        return filter
    }
}