package com.aquarius.provider.external.infochimpsgeo.api.json

import org.codehaus.jackson.map.DeserializerProvider
import org.codehaus.jackson.map.Deserializers
import org.codehaus.jackson.map.KeyDeserializers
import org.codehaus.jackson.map.deser.BeanDeserializerModifier
import org.codehaus.jackson.map.AbstractTypeResolver
import org.codehaus.jackson.map.JsonDeserializer
import org.codehaus.jackson.map.DeserializationConfig
import org.codehaus.jackson.type.JavaType
import org.codehaus.jackson.map.BeanProperty
import org.codehaus.jackson.map.KeyDeserializer
import org.codehaus.jackson.map.deser.StdDeserializerProvider

/**
 * TODO
 *
 * @since 03.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class InfochimpsDeserializerProvider extends StdDeserializerProvider{

    @Override
    DeserializerProvider withAdditionalDeserializers(Deserializers d) {
        return null
    }

    @Override
    DeserializerProvider withAdditionalKeyDeserializers(KeyDeserializers d) {
        return null
    }

    @Override
    DeserializerProvider withDeserializerModifier(BeanDeserializerModifier modifier) {
        return null
    }

    @Override
    DeserializerProvider withAbstractTypeResolver(AbstractTypeResolver resolver) {
        return null
    }

    @Override
    JsonDeserializer<Object> findValueDeserializer(DeserializationConfig config, JavaType propertyType, BeanProperty property) {
        return null
    }

    @Override
    JsonDeserializer<Object> findTypedValueDeserializer(DeserializationConfig config, JavaType type, BeanProperty property) {
        return null
    }

    @Override
    KeyDeserializer findKeyDeserializer(DeserializationConfig config, JavaType keyType, BeanProperty property) {
        return null
    }

    @Override
    boolean hasValueDeserializerFor(DeserializationConfig config, JavaType type) {
        return false
    }

    @Override
    int cachedDeserializersCount() {
        return 0
    }

    @Override
    void flushCachedDeserializers() {

    }
}
