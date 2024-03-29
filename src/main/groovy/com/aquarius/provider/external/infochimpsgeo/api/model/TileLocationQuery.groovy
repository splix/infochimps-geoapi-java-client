package com.aquarius.provider.external.infochimpsgeo.api.model

import groovy.transform.ToString

/**
 * Query for data in specified Google Map's tile (by x, y and zoom level)
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@ToString(includeFields = true, includeNames = true)
class TileLocationQuery extends LocationQuery {

    int x
    int y
    int zoomLevel

    @Override
    Map<String, Object> asParams() {
        return [
                'g.tile_x': x,
                'g.tile_y': y,
                'g.zoom_level': zoomLevel
        ] as Map
    }
}
