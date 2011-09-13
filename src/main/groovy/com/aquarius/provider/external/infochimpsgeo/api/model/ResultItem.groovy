package com.aquarius.provider.external.infochimpsgeo.api.model

import org.codehaus.jackson.annotate.JsonProperty
import com.aquarius.provider.external.infochimpsgeo.api.json.CoordinatesDeserializer
import org.codehaus.jackson.map.annotate.JsonDeserialize
import groovy.transform.ToString

/**
 * Result item
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@ToString
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

    @JsonProperty('extended_identifiers')
    Map<String, Object> extendedIdentifiers

    @JsonProperty('extended_properties')
    Map<String, Object> extendedProperties

    @JsonProperty('geo')
    Map<String, Object> geo

    @JsonProperty('feature_codes')
    Map<String, Object> featureCodes

    // -------------------------------

    String _type
    Map<String, Object> _meta
    @JsonProperty('_domain_id')
    String _domainId

}
