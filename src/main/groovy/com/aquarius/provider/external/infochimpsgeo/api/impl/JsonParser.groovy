package com.aquarius.provider.external.infochimpsgeo.api.impl

import com.aquarius.provider.external.infochimpsgeo.api.json.CoordinatesDeserializer
import com.aquarius.provider.external.infochimpsgeo.api.model.Coordinates
import org.codehaus.jackson.Version
import org.codehaus.jackson.map.module.SimpleModule
import org.codehaus.jackson.map.ObjectMapper
import com.aquarius.provider.external.infochimpsgeo.api.model.Result

/**
 * TODO
 *
 * @since 04.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class JsonParser {

    ObjectMapper objectMapper

    JsonParser() {
        objectMapper = new ObjectMapper()
        SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null))
        module.addDeserializer(Coordinates, new CoordinatesDeserializer())
        objectMapper.registerModule(module)
    }

    public <T extends Result> T parse(String json, Class<T> clazz) {
        return objectMapper.readValue(json, clazz)
    }
}
