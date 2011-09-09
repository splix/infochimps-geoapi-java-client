package com.aquarius.provider.external.infochimpsgeo.api.model

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.HttpInputMessageMock
import com.aquarius.provider.external.infochimpsgeo.api.impl.InfochimpsHttpMessageConverter

/**
 * TODO
 *
 * @since 09.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class LocationaryResultTest extends Specification {

    InfochimpsHttpMessageConverter converter = new InfochimpsHttpMessageConverter()

    def "Parse result with 4 items"() {
        setup:
            String json = this.class.classLoader.getResourceAsStream('testdata/locationary-4-items.json').text
            HttpInputMessageMock inputMessage = new HttpInputMessageMock(content: json)
        when:
            LocationaryResult result = converter.read(LocationaryResult, inputMessage)
        then:
            result != null
            result.total == 4
            result.results != null
            result.results.size() == 4

            result.results[0].md5id == '739707a84e26f38b84a62d122de77aa6'
            result.results[0].inside.contains('64987f7f2c9c2c43e3cabfc7fefb3caa')
            result.results[0].name == "Immortal Performances"
            result.results[0].coordinates == new Coordinates(-97.750788, 30.300999)
            result.results[0].country == "United States"
            result.results[0].state == "Texas"
            result.results[0].postalCode == 78703
            result.results[0].address == "1404 W 30th St"
            result.results[0].city == "Austin"

            result.results[1].md5id == "8e59912799a5a04c5e35902ae6b68e23"
            result.results[1].name == "Joe Klein"
            result.results[1].country == "United States"
            result.results[1].state == "Texas"
            result.results[1].postalCode == 78703
            result.results[1].address == "2815 Wooldridge Dr"
            result.results[1].city == "Austin"

            result.results[2].md5id == "67ec5a3aa4b669ecd94a0359468bb61d"
            result.results[2].name == "University Of Texas"
            result.results[2].country == "United States"
            result.results[2].state == "Texas"
            result.results[2].postalCode == 78712
            result.results[2].address == "224 Belmont Hall"
            result.results[2].city == "Austin"

            result.results[3].md5id == "d954bbeaa2bc038ed92c4fe7703a193f"
            result.results[3].name == "Immortal Performances Classicl"
            result.results[3].country == "United States"
            result.results[3].state == "Texas"
            result.results[3].postalCode == 78703
            result.results[3].address == "1404 W 30th St"
            result.results[3].city == "Austin"
    }

}
