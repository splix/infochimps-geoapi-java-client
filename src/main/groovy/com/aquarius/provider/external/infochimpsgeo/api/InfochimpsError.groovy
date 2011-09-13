package com.aquarius.provider.external.infochimpsgeo.api

import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource
import com.aquarius.provider.external.infochimpsgeo.api.model.QueryFilter
import com.aquarius.provider.external.infochimpsgeo.api.model.LocationQuery

/**
 * Error details
 *
 * @since 12.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class InfochimpsError {

    Exception exception
    GeoSource source
    Set<QueryFilter> filters
    LocationQuery query

}
