package com.aquarius.provider.external.infochimpsgeo.api.model

import org.codehaus.jackson.annotate.JsonProperty
import org.codehaus.jackson.annotate.JsonIgnoreProperties
import groovy.transform.ToString

/**
 * Foursquare result item
 *
 * @since 07.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@ToString(includeFields = true, includeNames = true, includeSuper=true)
class FoursqResultItem extends ResultItem {

    @JsonProperty('feature_codes')
    Map<String, String> featureCodes
    @JsonProperty('timezone')
    String timeZone

    String name
}
