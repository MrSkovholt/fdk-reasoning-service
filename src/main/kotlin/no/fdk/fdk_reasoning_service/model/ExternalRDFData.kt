package no.fdk.fdk_reasoning_service.model

import org.apache.jena.rdf.model.Model

data class ExternalRDFData(
    val orgData: Model,
    val losData: Model,
    val eurovocs: Model,
    val dataThemes: Model,
    val conceptStatuses: Model,
    val conceptSubjects: Model,
    val ianaMediaTypes: Model,
    val fileTypes: Model,
    val openLicenses: Model,
    val linguisticSystems: Model,
    val locations: Model
)
