package com.aquarius.provider.external.infochimpsgeo.api.model

/**
 * Query by box coordinates
 *
 * @since 07.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class BoxLocationQuery extends LocationQuery {

    Coordinates southWest
    Coordinates northEast

    BoxLocationQuery(double swLat, double swLon, double neLat, double neLon) {
        southWest = new Coordinates(
                longitude: swLon,
                latitude: swLat
        )
        northEast = new Coordinates(
                longitude: neLon,
                latitude: neLat
        )
    }

    @Override
    Map<String, Object> asParams() {
        return [
                'g.bbox': [southWest.latitude, southWest.longitude, northEast.latitude, northEast.longitude].join(',')
        ] as Map
    }
}
