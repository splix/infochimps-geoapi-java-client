package com.aquarius.provider.external.infochimpsgeo.api

import com.aquarius.provider.external.infochimpsgeo.api.model.Result
import com.aquarius.provider.external.infochimpsgeo.api.model.LocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.QueryFilter
import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource

/**
 *  Infochimps Geo Client
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
interface InfochimpsGeo {

   Result executeQueryWikipedia(GeoSource source, LocationQuery query, Set<QueryFilter> filters) throws InfochimpsGeoException

}
