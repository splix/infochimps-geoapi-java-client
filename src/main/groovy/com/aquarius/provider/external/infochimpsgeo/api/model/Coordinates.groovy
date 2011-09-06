package com.aquarius.provider.external.infochimpsgeo.api.model

/**
 * Longitude + Latitude
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class Coordinates {

    Double longitude

    Double latitude

    boolean equals(o) {
        if (this.is(o)) return true;
        if (!(o instanceof Coordinates)) return false;

        Coordinates that = (Coordinates) o;

        if (latitude != that.latitude) return false;
        if (longitude != that.longitude) return false;

        return true;
    }

    int hashCode() {
        int result;
        result = (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        return result;
    }

    @Override
    String toString() {
        return "longitude: $longitude, latitude: $latitude"
    }


}
