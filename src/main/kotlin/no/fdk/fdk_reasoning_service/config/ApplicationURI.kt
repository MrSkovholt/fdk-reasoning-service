package no.fdk.fdk_reasoning_service.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("application.uri")
data class ApplicationURI(
    val orgExternal: String,
    val orgInternal: String,
    val los: String
)
