package com.aquarius.provider.external.infochimpsgeo.api.model

/**
 * TODO
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class WikipediaResultItem extends ResultItem {

    /**
     * 	Title of the article
     */
    String title

    /**
     * 	This is the URL-encoded title. For most folks it is the best
     * 	practical ID of a topic, but for the true identifier of a page
     * 	please use the `wikipedia_numeric_id`.
     */
    String wikipediaId

    /**
     * URL of the wikipedia article.
     */
    URL url

    /**
     * The Wikipedia Article brief abstract.
     */
    String description

    /**
     * The Wikipedia Article extended abstract.
     */
    String summary

    /**
     * Images illustrating the topic of this article
     */
    List<String> images

    /**
     * 	The location of the content. Uses geographic coordinates extracted from Wikipedia.
     */
    Coordinates coordinates

    /**
     * The keywords/tags used to describe this content. These are chosen from the ???
     */
    List<String> keywords

    /**
     * An md5 hex digest that, together with the domain, uniquely identifies this record.
     */
    String md5id

    List<String> inside
    List<String> intersects

    GeoGeometryType geoGeometryType

    List<String> yagoClasses

    URL freebaseLink
}
