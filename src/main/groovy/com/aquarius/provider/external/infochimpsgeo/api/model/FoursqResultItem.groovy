package com.aquarius.provider.external.infochimpsgeo.api.model

import org.codehaus.jackson.annotate.JsonProperty
import org.codehaus.jackson.annotate.JsonIgnoreProperties

/**
 * TODO
 *
 * @since 07.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class FoursqResultItem extends ResultItem {

    @JsonProperty('feature_codes')
    Map<String, String> featureCodes
    @JsonProperty('timezone')
    String timeZone

    String name
}
