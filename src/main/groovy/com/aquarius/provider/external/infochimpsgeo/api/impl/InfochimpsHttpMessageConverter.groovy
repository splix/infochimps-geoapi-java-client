package com.aquarius.provider.external.infochimpsgeo.api.impl

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter
import com.aquarius.provider.external.infochimpsgeo.api.json.CoordinatesDeserializer
import com.aquarius.provider.external.infochimpsgeo.api.model.Coordinates
import org.codehaus.jackson.Version
import org.codehaus.jackson.map.module.SimpleModule
import org.codehaus.jackson.map.ObjectMapper

/**
 * TODO
 *
 * @since 05.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class InfochimpsHttpMessageConverter extends MappingJacksonHttpMessageConverter {

    InfochimpsHttpMessageConverter() {
        super()

        ObjectMapper objectMapper = new ObjectMapper()
        SimpleModule module = new SimpleModule("InfochimpsModule", new Version(1, 0, 0, null))
        module.addDeserializer(Coordinates, new CoordinatesDeserializer())
        objectMapper.registerModule(module)

        this.objectMapper = objectMapper
    }
}
