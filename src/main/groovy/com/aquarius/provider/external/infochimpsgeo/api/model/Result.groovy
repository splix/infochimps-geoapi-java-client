package com.aquarius.provider.external.infochimpsgeo.api.model

/**
 * Results list
 *
 * @since 03.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
abstract class Result<T> {

    int total
    List<T> results

}
