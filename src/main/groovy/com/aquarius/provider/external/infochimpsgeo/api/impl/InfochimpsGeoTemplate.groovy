package com.aquarius.provider.external.infochimpsgeo.api.impl

import com.aquarius.provider.external.infochimpsgeo.api.model.Result
import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource
import com.aquarius.provider.external.infochimpsgeo.api.model.LocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.QueryFilter
import com.aquarius.provider.external.infochimpsgeo.api.InfochimpsGeo
import com.aquarius.provider.external.infochimpsgeo.api.InfochimpsGeoException

/**
 * Infochimps Geo Client default implementation
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class InfochimpsGeoTemplate implements InfochimpsGeo {

    Result executeQueryWikipedia(GeoSource source, LocationQuery query, Set<QueryFilter> filters) throws InfochimpsGeoException {
        return null
    }

}
