package com.aquarius.provider.external.infochimpsgeo.api.impl

import com.aquarius.provider.external.infochimpsgeo.api.InfochimpsErrorHandler
import com.aquarius.provider.external.infochimpsgeo.api.InfochimpsError
import com.aquarius.provider.external.infochimpsgeo.api.model.Result

/**
 * Prints request info and rethrows original exception
 *
 * @since 12.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class TraceErrorHandler implements InfochimpsErrorHandler {

    Result onError(InfochimpsError error) {
        println "* API Call failed"
        println "* API: $error.source"
        println "* Query: $error.query"
        println "* Filters: $error.filters"
        println "* Error message: $error.exception.message"
        throw error.exception
    }
}
