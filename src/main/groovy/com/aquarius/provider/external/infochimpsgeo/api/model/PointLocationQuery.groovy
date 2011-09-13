package com.aquarius.provider.external.infochimpsgeo.api.model

import groovy.transform.ToString

/**
 * Query by coordinates + radius
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@ToString(includeFields = true, includeNames = true)
class PointLocationQuery extends LocationQuery {

    Coordinates coordinates

    /**
     * in meters
     */
    int radius

    PointLocationQuery() {
    }


    PointLocationQuery(Coordinates coordinates, int radius) {
        this.coordinates = coordinates
        this.radius = radius
    }

    PointLocationQuery(double latitude, double longitude, int radius) {
        this.coordinates = new Coordinates(
                longitude: longitude,
                latitude: latitude
        )
        this.radius = radius
    }

    @Override
    Map<String, Object> asParams() {
        return [
                'g.longitude': coordinates.longitude,
                'g.latitude': coordinates.latitude,
                'g.radius': radius
        ] as Map
    }
}
