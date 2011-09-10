package com.aquarius.provider.external.infochimpsgeo.api

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.impl.InfochimpsGeoTemplate
import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource
import com.aquarius.provider.external.infochimpsgeo.api.model.LocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.PointLocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.WikipediaResult
import com.aquarius.provider.external.infochimpsgeo.api.model.BoxLocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.Result

/**
 * TODO
 *
 * @since 06.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class MakeRealRequest extends Specification {

    String apiKey = 'splix-V3yuevgolGmEkrRaHVDGgsgkm69'
    InfochimpsGeoTemplate infochimpsGeoTemplate = new InfochimpsGeoTemplate(
            apiKey: apiKey
    )

    def wikipedia() {
        when:
            Result result = infochimpsGeoTemplate.executeQuery(GeoSource.Wikipedia, query, null)
        then:
            result != null
            result.total == count
            result.results.size() == count
        where:
            count | query
            2     | new PointLocationQuery(30.273054, -104.02, 5000)
            11    | new BoxLocationQuery(37.7993,-122.2777,37.8077,-122.2682)
    }


    def foursquare() {
        when:
            Result result = infochimpsGeoTemplate.executeQuery(GeoSource.Foursquare, query, null)
        then:
            result != null
            result.total == count
            result.results.size() == count
        where:
            count | query
            5     | new PointLocationQuery(30.273054, -104.02, 5000)
    }

    def locationary() {
        when:
            Result result = infochimpsGeoTemplate.executeQuery(GeoSource.Locationary, query, null)
        then:
            result != null
            result.total == count
            result.results.size() == count
        where:
            count | query
            4     | new PointLocationQuery(30.3, -97.75, 150)
    }

    def geonames() {
        when:
            Result result = infochimpsGeoTemplate.executeQuery(GeoSource.GeoNames , query, null)
        then:
            result != null
            result.total == count
            result.results.size() == count
        where:
            count | query
            5     | new PointLocationQuery(30.3, -97.75, 200)
    }
}
