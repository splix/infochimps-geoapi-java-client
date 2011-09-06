package com.aquarius.provider.external.infochimpsgeo.api.model

/**
 * Query by coordinates + radius
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
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

    PointLocationQuery(double longitude, double latitude, int radius) {
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
