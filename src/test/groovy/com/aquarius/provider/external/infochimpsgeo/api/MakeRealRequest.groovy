package com.aquarius.provider.external.infochimpsgeo.api

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.impl.InfochimpsGeoTemplate
import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource
import com.aquarius.provider.external.infochimpsgeo.api.model.LocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.PointLocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.AddressLocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.WikipediaResult
import com.aquarius.provider.external.infochimpsgeo.api.model.BoxLocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.Result
import spock.lang.Timeout

/**
 * TODO
 *
 * @since 06.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class MakeRealRequest extends Specification {

    String apiKey = 'api_test-W1cipwpcdu9Cbd9pmm8D4Cjc469'
    InfochimpsGeoTemplate infochimpsGeoTemplate = new InfochimpsGeoTemplate(
            apiKey: apiKey
    )

    @Timeout(10)
    def wikipedia() {
        when:
            Result result = infochimpsGeoTemplate.executeQuery(GeoSource.Wikipedia, query, null)
        then:
            println "Got $result for $query against Wikipedia"
            result != null
            result.total == count
            result.results.size() == count
        where:
            count | query
            2     | new PointLocationQuery(30.273054, -104.02, 5000)
            11    | new BoxLocationQuery(37.7993,-122.2777,37.8077,-122.2682)
    }

    @Timeout(10)
    def foursquare() {
        when:
            Result result = infochimpsGeoTemplate.executeQuery(GeoSource.Foursquare, query, null)
        then:
            println "Got $result for $query against Foursquare"
            result != null
            result.total == count
            result.results.size() == count
        where:
            count | query
            5     | new PointLocationQuery(30.273054, -104.02, 5000)
            16    | new AddressLocationQuery(address: 'NY', radius: 10000)
    }

    @Timeout(10)
    def locationary() {
        when:
            Result result = infochimpsGeoTemplate.executeQuery(GeoSource.Locationary, query, null)
        then:
            println "Got $result for $query against Locationary"
            result != null
            result.total == count
            result.results.size() == count
        where:
            count | query
            4     | new PointLocationQuery(30.3, -97.75, 150)
    }

    @Timeout(10)
    def geonames() {
        when:
            Result result = infochimpsGeoTemplate.executeQuery(GeoSource.GeoNames , query, null)
        then:
            println "Got $result for $query against Geonames"
            result != null
            result.total == count
            result.results.size() == count
        where:
            count | query
            5     | new PointLocationQuery(30.3, -97.75, 200)
    }
}
