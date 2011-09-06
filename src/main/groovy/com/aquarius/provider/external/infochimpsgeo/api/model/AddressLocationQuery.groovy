package com.aquarius.provider.external.infochimpsgeo.api.model

/**
 * Query by address as text + radius
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class AddressLocationQuery extends LocationQuery {

    String address

    /**
     * In meters
     */
    int radius

    @Override
    Map<String, Object> asParams() {
        return [
                'g.address_text': address,
                'g.radius': radius
        ] as Map
    }
}
