package com.aquarius.provider.external.infochimpsgeo.api.model

import org.codehaus.jackson.annotate.JsonIgnoreProperties
import org.codehaus.jackson.annotate.JsonProperty
import groovy.transform.ToString

/**
 * Locationary result item
 *
 * @since 09.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@ToString(includeFields = true, includeNames = true, includeSuper=true)
class LocationaryResultItem extends ResultItem {

    String name

    String country
    String state
    @JsonProperty('postal_code')
    int postalCode

    String address
    String city
}
