package com.aquarius.provider.external.infochimpsgeo.api.impl

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.model.WikipediaResult
import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource

/**
 * TODO
 *
 * @since 04.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class InfochimpsGeoTemplateTest extends Specification {

    InfochimpsGeoTemplate geoTemplate = new InfochimpsGeoTemplate()

    def "Load one result"() {
        setup:
            String json = this.class.classLoader.getResourceAsStream('testdata/wikipedia-one-item.json').text
            HttpLoader httpLoader = Mock()
            geoTemplate.httpLoader = httpLoader
        when:
            WikipediaResult result = geoTemplate.executeQuery(GeoSource.Wikipedia, null, null)
        then:
            1 * httpLoader.getJson('/encyclopedic/wikipedia/dbpedia/wikipedia_articles/search', _) >> json
            result != null
            result.total == 1
            result.results.size() == 1
            result.results[0].wikipediaId == 5436443
    }
}
