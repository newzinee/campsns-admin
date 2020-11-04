package com.campfour.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Thumbnail {
    private String thumbnailLow;
    private String thumbnailMedium;
    private String thumbnailHigh;

}
