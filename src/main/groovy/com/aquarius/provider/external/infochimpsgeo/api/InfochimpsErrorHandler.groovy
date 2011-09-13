package com.aquarius.provider.external.infochimpsgeo.api

import com.aquarius.provider.external.infochimpsgeo.api.model.Result

/**
 * Handles errors of Infochimps API calls
 *
 * @since 12.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
public interface InfochimpsErrorHandler {

    Result onError(InfochimpsError error)

}