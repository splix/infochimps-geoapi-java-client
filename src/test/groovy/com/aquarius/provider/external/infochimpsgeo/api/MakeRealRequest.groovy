package com.aquarius.provider.external.infochimpsgeo.api

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.impl.InfochimpsGeoTemplate
import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource
import com.aquarius.provider.external.infochimpsgeo.api.model.LocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.PointLocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.WikipediaResult
import com.aquarius.provider.external.infochimpsgeo.api.model.BoxLocationQuery

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

    def "Wikipedia"() {
        when:
            WikipediaResult result = infochimpsGeoTemplate.executeQuery(GeoSource.Wikipedia, query, filters)
        then:
            result != null
            result.total == count
            result.results.size() == count
        where:
            count | query                               | filters
            2  | new PointLocationQuery(30.273054, -104.02, 5000) | null
            11 | new BoxLocationQuery(37.7993,-122.2777,37.8077,-122.2682) | null
    }
}
