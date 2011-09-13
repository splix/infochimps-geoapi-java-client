package com.aquarius.provider.external.infochimpsgeo.api.model

import org.codehaus.jackson.annotate.JsonProperty
import groovy.transform.ToString

/**
 * TODO
 *
 * @since 09.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@ToString(includeFields = true, includeNames = true, includeSuper=true)
class GeonamesResultItem extends ResultItem {

    String name

    @JsonProperty('country_id')
    String country

    @JsonProperty('state_id')
    String state

    @JsonProperty('county_id')
    String countyId

    @JsonProperty('time_zone_geo_id')
    String timeZone

}
