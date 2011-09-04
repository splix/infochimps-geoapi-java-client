package com.aquarius.provider.external.infochimpsgeo.api.impl

import org.apache.http.client.HttpClient
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import org.apache.http.client.utils.URLEncodedUtils
import org.apache.http.client.utils.URIUtils
import org.apache.http.client.methods.HttpGet
import org.apache.http.HttpResponse
import org.apache.http.HttpEntity
import org.apache.http.util.EntityUtils
import org.slf4j.LoggerFactory
import org.slf4j.Logger

/**
 * TODO
 *
 * @since 03.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class HttpLoader {

    private static final Logger log = LoggerFactory.getLogger(this)

    String getJson(String path, Map params) {
        HttpClient httpClient = new DefaultHttpClient()

        List<NameValuePair> qparams = new ArrayList<NameValuePair>()
        params.entrySet().each { Map.Entry<String, Object> it ->
            qparams.add(new BasicNameValuePair(it.key, it.value.toString()))
        }

        URI uri = URIUtils.createURI("http", "api.infochimps.com", -1, path,
            URLEncodedUtils.format(qparams, "UTF-8"), null)

        HttpGet httpget = new HttpGet(uri)
        HttpResponse response = httpClient.execute(httpget)
        HttpEntity entity = response.entity

        String json = null

        if (response.getFirstHeader('Content-Type') != 'application/json') {
            log.error('Invalid response type: ' + response.getFirstHeader('Content-Type'))
            return ''
        }

        if (entity != null) {
            json = entity.content.text
        } else {
            log.error('No reponse')
        }

        return json
    }
}
