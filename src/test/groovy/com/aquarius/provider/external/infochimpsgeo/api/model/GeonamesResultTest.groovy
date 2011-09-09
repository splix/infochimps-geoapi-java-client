package com.aquarius.provider.external.infochimpsgeo.api.model

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.impl.InfochimpsHttpMessageConverter
import com.aquarius.provider.external.infochimpsgeo.api.HttpInputMessageMock

/**
 * TODO
 *
 * @since 09.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class GeonamesResultTest extends Specification {

    InfochimpsHttpMessageConverter converter = new InfochimpsHttpMessageConverter()

    def "Parse result with 5 items"() {
        setup:
            String json = this.class.classLoader.getResourceAsStream('testdata/geonames-5-items.json').text
            HttpInputMessageMock inputMessage = new HttpInputMessageMock(content: json)
        when:
            GeonamesResult result = converter.read(GeonamesResult, inputMessage)
        then:
            result != null
            result.total == 5
            result.results != null
            result.results.size() == 5

            result.results[0].md5id == 'a23d5aa097440cb2c9372cfb84391771'
            result.results[0].name == "Herbert and Alice Bohn House"
            result.results[0].coordinates == new Coordinates(-97.75112, 30.29993)
            result.results[0].country == "US"
            result.results[0].state == "TX"
            result.results[0].countyId == "453"
            result.results[0].timeZone == "America/Chicago"
            result.results[0].extendedIdentifiers == [
                    "geonames_id": "4697215",
                    "ascii_name": "Herbert and Alice Bohn House"
            ]
            result.results[0].extendedProperties == [
                    "state_fips_id": "TX"
            ]
            result.results[0].geo == [
                    "elevation": 182,
                    "average_elevation": 182
            ]
            result.results[0].featureCodes == [
                    "geonames_feature_code": "S.BLDG"
            ]


        result.results[1].md5id == '1d97b88daec6e9ad5fe0797b826500b3'
        result.results[1].country == "US"
        result.results[1].state == "TX"
        result.results[1].countyId == "453"

        result.results[2].md5id == '8361ff471f66ccce59eef992f9ee9104'
        result.results[2].name == "Herbert and Alice Bohn House"
        result.results[2].coordinates == new Coordinates(-97.75112, 30.29993)
        result.results[2].timeZone == "America/Chicago"

        result.results[3].md5id == '75aa7bac45fa8a2f2ee2663214c9ccc0'

        result.results[4].md5id == 'cc3fc612b4fdc43f9bf7aa2c10d5899b'
    }
}
