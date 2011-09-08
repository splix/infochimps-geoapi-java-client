package com.aquarius.provider.external.infochimpsgeo.api.impl

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.model.WikipediaResult
import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource
import com.aquarius.provider.external.infochimpsgeo.api.model.AddressLocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.QueryFilter
import org.springframework.web.client.RestTemplate
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.ClientHttpRequest
import org.springframework.http.HttpMethod
import org.springframework.http.HttpHeaders
import org.springframework.http.client.ClientHttpResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class InfochimpsGeoTemplateTest extends Specification {

    InfochimpsGeoTemplate geoTemplate = new InfochimpsGeoTemplate()
    String wikipediaApi = 'http://api.infochimps.com/encyclopedic/wikipedia/dbpedia/wikipedia_articles/search?apikey=NotConfigured'

    def "Load one result"() {
        setup:
            String json = this.class.classLoader.getResourceAsStream('testdata/wikipedia-one-item.json').text
            ClientHttpRequestFactory requestFactory = Mock()
            ClientHttpRequest request = Mock()
            ClientHttpResponse response = Mock()
            HttpHeaders responseHeaders = new HttpHeaders()
            responseHeaders.contentType = MediaType.APPLICATION_JSON
            geoTemplate.restTemplate.requestFactory = requestFactory
        when:
            WikipediaResult result = geoTemplate.executeQuery(GeoSource.Wikipedia, null, null)
        then:
            1 * requestFactory.createRequest(
                    new URI(wikipediaApi),
                    HttpMethod.GET) >> request
            1 * request.headers >> new HttpHeaders()
            1 * request.execute() >> response
            _ * response.statusCode >> HttpStatus.OK
            _ * response.headers >> responseHeaders
            1 * response.body >> new ByteArrayInputStream(json.bytes)
            result != null
            result.total == 1
            result.results.size() == 1
            result.results[0].wikipediaId == 5436443
    }

    def "Use location params"() {
        setup:
            AddressLocationQuery query = new AddressLocationQuery(
                    address: '10 Hannover Sq., NY',
                    radius: 500
            )
            RestTemplate restTemplate = Mock()
            geoTemplate.restTemplate = restTemplate
            String reqUrl = [wikipediaApi,
                         '&g.address_text=10%20Hannover%20Sq.,%20NY',
                         '&g.radius=500'].join('')
        when:
            geoTemplate.executeQuery(GeoSource.Wikipedia, query, null)
        then:
            1 * restTemplate.getForObject(_ as URI, _ as Class) >> { url, clz ->
                assert reqUrl.equals(url.toString())
                return null
            }
    }

    def "Use filter params"() {
        setup:
            Set filters = [
                    new QueryFilter(
                            fieldName: 'x',
                            filter: '1'
                    ),
                    new QueryFilter(
                            fieldName: 'y',
                            filter: '5'
                    ),
            ]
            RestTemplate restTemplate = Mock()
            geoTemplate.restTemplate = restTemplate
            String reqUrl = [wikipediaApi,
                         '&f.x=1',
                         '&f.y=5'].join('')
        when:
            geoTemplate.executeQuery(GeoSource.Wikipedia, null, filters)
        then:
            1 * restTemplate.getForObject(_ as URI, _ as Class) >> { URI url, clz ->
                assert reqUrl.equals(url.toString())
                return null
            }
    }

}
