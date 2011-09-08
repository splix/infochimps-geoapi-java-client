package com.aquarius.provider.external.infochimpsgeo.api.model

import org.codehaus.jackson.annotate.JsonProperty
import org.codehaus.jackson.annotate.JsonIgnoreProperties
import org.codehaus.jackson.map.annotate.JsonSerialize
import com.aquarius.provider.external.infochimpsgeo.api.json.CoordinatesDeserializer
import org.codehaus.jackson.map.annotate.JsonDeserialize

/**
 * Wikipedia result item
 *
 * @since 02.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class WikipediaResultItem extends ResultItem {

    /**
     * 	Title of the article
     */
    String title

    @JsonProperty('wikipedia_id')
    int wikipediaId

    /**
     * URL of the wikipedia article.
     */
    URL url

    /**
     * The Wikipedia Article abstract.
     *
     * NOTE: `abstract` is reserved keyword for Java, therefor 'summary' is used here
     */
    @JsonProperty('abstract')
    String summary

    /**
     * Images illustrating the topic of this article
     */
    List<String> images

    /**
     * The keywords/tags used to describe this content. These are chosen from the ???
     */
    List<String> keywords

    @JsonProperty('yago_classes')
    List<String> yagoClasses

    @JsonProperty('freebase_link')
    URL freebaseLink

    @JsonProperty('related_pages')
    List<String> relatedPages
}
