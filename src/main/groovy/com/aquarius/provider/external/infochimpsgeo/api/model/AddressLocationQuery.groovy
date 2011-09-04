package com.aquarius.provider.external.infochimpsgeo.api.model

/**
 * TODO
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class AddressLocationQuery extends LocationQuery {

    String address

    /**
     * in meters
     */
    int radius
}
