package no.fdk.fdk_reasoning_service.utils

import no.fdk.fdk_reasoning_service.model.TurtleDBO
import no.fdk.fdk_reasoning_service.service.gzip
import org.bson.Document

private val responseReader = TestResponseReader()

val EVENT_UNION_DATA = TurtleDBO(
    id = "event-union-graph",
    turtle = gzip(responseReader.readFile("events.ttl"))
)

val PUBLIC_SERVICE_UNION_DATA = TurtleDBO(
    id = "services-union-graph",
    turtle = gzip(responseReader.readFile("public_services.ttl"))
)

val DATASET_UNION_DATA = TurtleDBO(
    id = "catalog-union-graph",
    turtle = gzip(responseReader.readFile("datasets.ttl"))
)

val CONCEPT_UNION_DATA = TurtleDBO(
    id = "collection-union-graph",
    turtle = gzip(responseReader.readFile("concepts.ttl"))
)

val DATA_SERVICE_UNION_DATA = TurtleDBO(
    id = "catalog-union-graph",
    turtle = gzip(responseReader.readFile("dataservices.ttl"))
)

fun TurtleDBO.mapDBO(): Document =
    Document()
        .append("_id", id)
        .append("turtle", turtle)