package com.aquarius.provider.external.infochimpsgeo.api.impl

import com.aquarius.provider.external.infochimpsgeo.api.model.GeoSource
import com.aquarius.provider.external.infochimpsgeo.api.model.LocationQuery
import com.aquarius.provider.external.infochimpsgeo.api.model.QueryFilter
import com.aquarius.provider.external.infochimpsgeo.api.InfochimpsGeo
import com.aquarius.provider.external.infochimpsgeo.api.InfochimpsGeoException
import org.springframework.web.client.RestTemplate
import com.aquarius.provider.external.infochimpsgeo.api.model.ResultItem
import com.aquarius.provider.external.infochimpsgeo.api.model.Result
import com.aquarius.provider.external.infochimpsgeo.api.model.WikipediaResultItem
import com.aquarius.provider.external.infochimpsgeo.api.model.WikipediaResult

/**
 * Infochimps Geo Client default implementation
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class InfochimpsGeoTemplate implements InfochimpsGeo {

    static Map<GeoSource, String> urls = [:]
    static Map<GeoSource, Class> classes = [:]
    static {
        urls.put(GeoSource.Wikipedia, '/encyclopedic/wikipedia/dbpedia/wikipedia_articles/search')
        classes.put(GeoSource.Wikipedia, WikipediaResult)
    }

    HttpLoader httpLoader = new HttpLoader()
    JsonParser jsonParser = new JsonParser()

    Result executeQuery(GeoSource source, LocationQuery query, Set<QueryFilter> filters) throws InfochimpsGeoException {
        Map params = [:]
        if (query) { //TODO can it be empty?
            params.putAll(query.asParams())
        }

        if (filters) {
            filters.each {
                params.put('f.'+it.fieldName, it.filter)
            }
        }

        String json = httpLoader.getJson(urls.get(source), params)
        if (!json || json.length() == 0) {
            //TODO throw an error?
            return null
        }
        Class clazz = classes.get(source)
        return jsonParser.parse(json, clazz)
    }

}
