package com.aquarius.provider.external.infochimpsgeo.api.model

import groovy.transform.ToString

/**
 * Geonames result
 *
 * @since 09.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@ToString(includeFields = true, includeNames = true, includeSuper=true)
class GeonamesResult extends Result<GeonamesResultItem> {
}
