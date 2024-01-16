package no.fdk.fdk_reasoning_service.utils

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import java.io.File

const val LOCAL_SERVER_PORT = 5000

private val mockserver = WireMockServer(LOCAL_SERVER_PORT)

fun startMockServer() {
    if(!mockserver.isRunning) {
        mockserver.stubFor(get(urlEqualTo("/ping"))
            .willReturn(aResponse().withStatus(200)))

        mockserver.stubFor(get(urlEqualTo("/organizations"))
            .willReturn(ok(File("src/test/resources/orgs.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/organizations/972417866"))
            .willReturn(ok(File("src/test/resources/org.ttl").readText())))
        mockserver.stubFor(get(urlMatching("/organizations/orgpath/.*"))
            .willReturn(ok("/GENERATED/ORGPATH")))
        mockserver.stubFor(get(urlEqualTo("/reference-data/los"))
            .willReturn(ok(File("src/test/resources/los.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/eu/eurovocs"))
            .willReturn(ok(File("src/test/resources/eurovocs.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/eu/data-themes"))
            .willReturn(ok(File("src/test/resources/data_themes.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/eu/concept-statuses"))
            .willReturn(ok(File("src/test/resources/concept_statuses.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/digdir/concept-subjects"))
            .willReturn(ok(File("src/test/resources/concept_subjects.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/iana/media-types"))
            .willReturn(ok(File("src/test/resources/media_types.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/open-licenses"))
            .willReturn(ok(File("src/test/resources/open_licenses.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/iana/linguistic-systems"))
            .willReturn(ok(File("src/test/resources/linguistic_systems.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/geonorge/administrative-enheter/nasjoner"))
            .willReturn(ok(File("src/test/resources/nasjoner.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/geonorge/administrative-enheter/fylker"))
            .willReturn(ok(File("src/test/resources/fylker.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/geonorge/administrative-enheter/kommuner"))
            .willReturn(ok(File("src/test/resources/kommuner.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/eu/access-rights"))
            .willReturn(ok(File("src/test/resources/access_rights.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/eu/frequencies"))
            .willReturn(ok(File("src/test/resources/frequencies.ttl").readText())))
        mockserver.stubFor(get(urlEqualTo("/reference-data/provenance-statements"))
            .willReturn(ok(File("src/test/resources/provenance_statements.ttl").readText())))

        mockserver.start()
    }
}

fun stopMockServer() {

    if (mockserver.isRunning) mockserver.stop()

}
