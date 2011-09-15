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
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.map.module.SimpleModule
import org.codehaus.jackson.Version
import com.aquarius.provider.external.infochimpsgeo.api.model.Coordinates
import com.aquarius.provider.external.infochimpsgeo.api.json.CoordinatesDeserializer
import org.springframework.web.util.UriUtils
import com.aquarius.provider.external.infochimpsgeo.api.model.FoursqResult
import com.aquarius.provider.external.infochimpsgeo.api.model.LocationaryResult
import com.aquarius.provider.external.infochimpsgeo.api.model.GeonamesResult
import com.aquarius.provider.external.infochimpsgeo.api.InfochimpsErrorHandler
import com.aquarius.provider.external.infochimpsgeo.api.InfochimpsError
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory

/**
 * Infochimps Geo Client default implementation
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class InfochimpsGeoTemplate implements InfochimpsGeo {

    static int DEFAULT_TIMEOUT = 20000

    static Map<GeoSource, String> urls = [:]
    static Map<GeoSource, Class> classes = [:]
    static {
        urls.put(GeoSource.Wikipedia, '/encyclopedic/wikipedia/dbpedia/wikipedia_articles/search')
        classes.put(GeoSource.Wikipedia, WikipediaResult)

        urls.put(GeoSource.Foursquare, '/geo/location/foursquare/places/search')
        classes.put(GeoSource.Foursquare, FoursqResult)

        urls.put(GeoSource.Locationary, '/geo/location/locationary/places/search')
        classes.put(GeoSource.Locationary, LocationaryResult)

        urls.put(GeoSource.GeoNames, '/geo/location/geonames/places/search')
        classes.put(GeoSource.GeoNames, GeonamesResult)
    }

    static String server = 'http://api.infochimps.com'

    RestTemplate restTemplate
    String apiKey = 'NotConfigured'
    InfochimpsErrorHandler defaultErrorHandler = new TraceErrorHandler()

    InfochimpsGeoTemplate() {
        restTemplate = new RestTemplate()
        restTemplate.setMessageConverters([
                new InfochimpsHttpMessageConverter()
        ])
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory()
        requestFactory.readTimeout = DEFAULT_TIMEOUT
        restTemplate.requestFactory = requestFactory
    }

    Result executeQuery(GeoSource source, LocationQuery query, Set<QueryFilter> filters) throws InfochimpsGeoException {
        this.executeQuery(source, query, filters, defaultErrorHandler)
    }

    Result executeQuery(GeoSource source, LocationQuery query, Set<QueryFilter> filters, InfochimpsErrorHandler errorHandler) throws InfochimpsGeoException {
        Map params = [:]
        if (query) { //TODO can it be empty?
            params.putAll(query.asParams())
        }

        if (filters) {
            filters.each {
                params.put('f.'+it.fieldName, it.filter)
            }
        }

        if (apiKey) {
            params.put('apikey', apiKey)
        }

        String urlParams = params.entrySet().sort { x, y ->
            return x.key.compareToIgnoreCase(y.key)
        }.collect {
            String value = UriUtils.encodeQueryParam(it.value.toString(), 'UTF-8')
            return "$it.key=$value"
        }.join('&')

        String url = [
                server,
                urls.get(source),
                '?',
                urlParams
        ].join('')
        Class<Result> clazz = classes.get(source)

        try {
            return restTemplate.getForObject(new URI(url), clazz)
        } catch (Exception e) {
            if (defaultErrorHandler != null) {
                return defaultErrorHandler.onError(new InfochimpsError(
                        source: source,
                        query: query,
                        filters: filters,
                        exception: e
                ))
            } else {
                throw e
            }
        }
    }

}
