package com.aquarius.provider.external.infochimpsgeo.api.model

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.impl.InfochimpsHttpMessageConverter
import com.aquarius.provider.external.infochimpsgeo.api.HttpInputMessageMock

class WikipediaResultTest extends Specification {

    InfochimpsHttpMessageConverter converter = new InfochimpsHttpMessageConverter()

    def "Can parse input"() {
        setup:
            String json = this.class.classLoader.getResourceAsStream('testdata/wikipedia-one-item.json').text
            HttpInputMessageMock inputMessage = new HttpInputMessageMock(content: json)
        when:
            WikipediaResult result = converter.read(WikipediaResult, inputMessage)
        then:
            result != null
            result.total == 1
            result.results != null
            result.results.size() == 1
            result.results[0].md5id == '31ee610b67fb212f682990400d6ec304'
            result.results[0].url == new URL("http://en.wikipedia.org/wiki/Flamingo_Hotel,_Miami_Beach")
            result.results[0].coordinates == new Coordinates(
                    longitude: -80.14461,
                    latitude: 25.78687
            )
            result.results[0].geoGeometryType == GeoGeometryType.Point
            result.results[0].relatedPages == null
            result.results[0].wikipediaId == 5436443
            result.results[0].freebaseLink == new URL('http://rdf.freebase.com/ns/m/0dltd5')
            result.results[0].inside.size() == 9
            result.results[0].intersects.size() == 9
            result.results[0].yagoClasses == ["HotelsInMiamiBeach", "Florida"]
            result.results[0].title == 'Flamingo Hotel, Miami Beach'
            result.results[0].summary?.contains('designed by Price and McLanahan')
    }

    def "Parse result with 3 items"() {
        setup:
            String json = this.class.classLoader.getResourceAsStream('testdata/wikipedia-3-near-infochimps.json').text
            HttpInputMessageMock inputMessage = new HttpInputMessageMock(content: json)
        when:
            WikipediaResult result = converter.read(WikipediaResult, inputMessage)
        then:
            result != null
            result.total == 3
            result.results != null
            result.results.size() == 3
            result.results[0].md5id == '42bd9d853b8bd4f9c2052cbd1d580447'
            result.results[0].url == new URL("http://en.wikipedia.org/wiki/Austin_Public_Library")
            result.results[0].coordinates == new Coordinates(
                    longitude: -97.745834,
                    latitude: 30.271389
            )
            result.results[0].inside.size() == 9
            result.results[0].inside.contains('64987f7f2c9c2c43e3cabfc7fefb3caa')

            result.results[1].md5id == 'eaba0f153d854412296b8ce407e10ddf'
            result.results[1].wikipediaId ==  12169572
            result.results[1].geoGeometryType == GeoGeometryType.Point

            result.results[2].md5id == '584182d02fc61216af49d3d53c7c8d1a'
            result.results[2].wikipediaId ==  1443527
            result.results[2].relatedPages == ['United_States']

    }

}
