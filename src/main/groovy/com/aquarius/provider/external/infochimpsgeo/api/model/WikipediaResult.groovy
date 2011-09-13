package com.aquarius.provider.external.infochimpsgeo.api.model

import groovy.transform.ToString

/**
 * Results list for wikipedia query
 *
 * @since 03.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@ToString(includeFields = true, includeNames = true, includeSuper=true)
class WikipediaResult extends Result<WikipediaResultItem> {
}
