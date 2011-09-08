package com.aquarius.provider.external.infochimpsgeo.api.model

import spock.lang.Specification
import com.aquarius.provider.external.infochimpsgeo.api.impl.InfochimpsHttpMessageConverter
import com.aquarius.provider.external.infochimpsgeo.api.HttpInputMessageMock

/**
 * TODO
 *
 * @since 07.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class FoursqResultTest extends Specification {

    InfochimpsHttpMessageConverter converter = new InfochimpsHttpMessageConverter()

    def "Parse result with 5 items"() {
        setup:
            String json = this.class.classLoader.getResourceAsStream('testdata/foursquare-5-items.json').text
            HttpInputMessageMock inputMessage = new HttpInputMessageMock(content: json)
        when:
            FoursqResult result = converter.read(FoursqResult, inputMessage)
        then:
            result != null
            result.total == 5
            result.results != null
            result.results.size() == 5

            result.results[0].md5id == '273496dacf1707d7c7812291f622f69c'
            result.results[0].featureCodes == ["foursquare_feature_code": "Travel Spots:Hotels:Motels"]
            result.results[0].inside.contains('afdd0f0b66681f842d6e0cc9e4ce8fa8')
            result.results[0].timeZone == "America/North_Dakota/New_Salem"
            result.results[0].extendedIdentifiers == ["foursquare_venue_id": 1739515]
            result.results[0].name == "El Cosmico"
            result.results[0].coordinates == new Coordinates(-104.021751880646, 30.3028259327755)

            result.results[1].md5id == '6376d295636401d1fbb103bd55070454'
            result.results[1].featureCodes == ["foursquare_feature_code": "Arts & Entertainment:Art Galleries"]
            result.results[1].timeZone == "America/North_Dakota/New_Salem"
            result.results[1].extendedIdentifiers == ["foursquare_venue_id": 1716460]
            result.results[1].name == "The Chinati Foundation"
            result.results[1].coordinates == new Coordinates(-104.026139974594, 30.2996764749994)

            result.results[2].md5id == '6b2c5536e8bebee71761fcd75d454f94'
            result.results[2].featureCodes == ["foursquare_feature_code": "Nightlife Spots:Bars"]
            result.results[2].timeZone == "America/North_Dakota/New_Salem"
            result.results[2].extendedIdentifiers == ["foursquare_venue_id": 2488256]
            result.results[2].name == "Padre's Bar & Grill"

            result.results[3].md5id == '67b706ff127517a82fcb2fcbc0dde54e'
            result.results[3].featureCodes == ["foursquare_feature_code": ""]
            result.results[3].timeZone == "America/Chicago"
            result.results[3].extendedIdentifiers == ["foursquare_venue_id": 21863400]
            result.results[3].name == "Miniature Rooster"

            result.results[4].md5id == '1a13147ef7cc3a924da631da872094e9'
            result.results[4].featureCodes == ["foursquare_feature_code": "Great Outdoors:Other Great Outdoors"]
            result.results[4].timeZone == "America/Chicago"
            result.results[4].extendedIdentifiers == ["foursquare_venue_id": 497618]
            result.results[4].name == "Marfa, TX"

    }
}
