package com.aquarius.provider.external.infochimpsgeo.api.model

import org.codehaus.jackson.annotate.JsonProperty
import com.aquarius.provider.external.infochimpsgeo.api.json.CoordinatesDeserializer
import org.codehaus.jackson.map.annotate.JsonDeserialize

/**
 * Result item
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class ResultItem {

    /**
     * An md5 hex digest that, together with the domain, uniquely identifies this record.
     */
    String md5id

    List<String> inside
    List<String> intersects

    @JsonProperty('geo_geometry_type')
    GeoGeometryType geoGeometryType

    /**
     * 	The location of the content. Uses geographic coordinates extracted from Wikipedia.
     */
    @JsonDeserialize(using = CoordinatesDeserializer)
    Coordinates coordinates

}
