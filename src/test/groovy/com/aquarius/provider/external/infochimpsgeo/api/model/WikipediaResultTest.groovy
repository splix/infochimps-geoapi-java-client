package com.aquarius.provider.external.infochimpsgeo.api.model

import spock.lang.Specification
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.map.module.SimpleModule
import org.codehaus.jackson.Version
import com.aquarius.provider.external.infochimpsgeo.api.json.CoordinatesDeserializer

/**
 * TODO
 *
 * @since 03.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class WikipediaResultTest extends Specification {

    def "Can parse input"() {
        setup:
            String json = this.class.classLoader.getResourceAsStream('testdata/wikipedia-one-item.json').text
            ObjectMapper objectMapper = new ObjectMapper()
            SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null))
            module.addDeserializer(Coordinates, new CoordinatesDeserializer())
            objectMapper.registerModule(module)
        when:
            WikipediaResult result = objectMapper.readValue(json, WikipediaResult)
        then:
            result != null
            result.total == 1
            result.results != null
            result.results.size() == 1
            result.results[0].md5id == '31ee610b67fb212f682990400d6ec304'
            result.results[0].url == new URL("http://en.wikipedia.org/wiki/Flamingo_Hotel,_Miami_Beach")
    }
}
