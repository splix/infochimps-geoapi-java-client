package com.aquarius.provider.external.infochimpsgeo.api

import org.springframework.http.HttpInputMessage
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

/**
 * TODO
 *
 * @since 05.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class HttpInputMessageMock implements HttpInputMessage {

    String content

    InputStream getBody() {
        return new ByteArrayInputStream(content.getBytes('UTF-8'))
    }

    HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        return headers
    }
}
