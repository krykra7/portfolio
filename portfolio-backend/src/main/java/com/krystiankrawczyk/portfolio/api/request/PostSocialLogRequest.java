package com.krystiankrawczyk.portfolio.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.krystiankrawczyk.portfolio.db.enums.LinkType;

public class PostSocialLogRequest {

    private final LinkType linkType;
    private final String linkValue;

    public PostSocialLogRequest(
            @JsonProperty("linkType") LinkType linkType,
            @JsonProperty("linkValue") String linkValue) {
        this.linkType = linkType;
        this.linkValue = linkValue;
    }

    public LinkType getLinkType() {
        return linkType;
    }

    public String getLinkValue() {
        return linkValue;
    }
}
