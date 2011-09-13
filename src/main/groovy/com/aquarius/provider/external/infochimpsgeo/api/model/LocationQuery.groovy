package com.aquarius.provider.external.infochimpsgeo.api.model

import groovy.transform.ToString

/**
 * Query
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@ToString(includeFields = true, includeNames = true)
abstract class LocationQuery {

    abstract Map<String, Object> asParams()
}
