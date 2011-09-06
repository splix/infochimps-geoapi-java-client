package com.aquarius.provider.external.infochimpsgeo.api.json

import org.codehaus.jackson.map.JsonSerializer
import org.codehaus.jackson.JsonGenerator
import org.codehaus.jackson.map.SerializerProvider
import org.codehaus.jackson.map.JsonDeserializer
import org.codehaus.jackson.JsonParser
import org.codehaus.jackson.map.DeserializationContext
import com.aquarius.provider.external.infochimpsgeo.api.model.Coordinates
import org.codehaus.jackson.JsonToken

/**
 * Infochimps serializes coordinates as 2-element array, but we need
 * to convert it to longitude/latitude structure
 *
 * @since 03.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class CoordinatesDeserializer extends JsonDeserializer {

    @Override
    Object deserialize(JsonParser jp, DeserializationContext ctxt) {
        jp.nextValue()
        Double longitude = jp.doubleValue
        assert JsonToken.VALUE_NUMBER_FLOAT == jp.nextValue()
        Double latitude = jp.doubleValue
        assert JsonToken.END_ARRAY == jp.nextValue()
        return new Coordinates(
                longitude: longitude,
                latitude: latitude
        )
    }
}
