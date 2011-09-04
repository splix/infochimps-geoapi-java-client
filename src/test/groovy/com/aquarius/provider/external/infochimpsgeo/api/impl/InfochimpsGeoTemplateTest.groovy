package com.aquarius.provider.external.infochimpsgeo.api.impl

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.model.WikipediaResult
import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource
import com.aquarius.provider.external.infochimpsgeo.api.model.AddressLocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.QueryFilter

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

    def "Use location params"() {
        setup:
            HttpLoader httpLoader = Mock()
            geoTemplate.httpLoader = httpLoader
            AddressLocationQuery query = new AddressLocationQuery(
                    address: '10 Hannover Sq., NY, NY',
                    radius: 500
            )
        when:
            geoTemplate.executeQuery(GeoSource.Wikipedia, query, null)
        then:
            1 * httpLoader.getJson(_, _) >> { x, y ->
                assert y.size() == 2
                assert y['g.address_text'] == query.address
                assert y['g.radius'] == query.radius
                return null
            }
    }

    def "Use filter params"() {
        setup:
            HttpLoader httpLoader = Mock()
            geoTemplate.httpLoader = httpLoader
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
        when:
            geoTemplate.executeQuery(GeoSource.Wikipedia, null, filters)
        then:
            1 * httpLoader.getJson(_, _) >> { x, y ->
                assert y.size() == 2
                assert y['f.x'] == '1'
                assert y['f.y'] == '5'
                return null
            }
    }

}
