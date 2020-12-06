package com.campfour.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 사전조사
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Standard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "standard_id")
    private Long id;
    private String name;
    private String image;

    @OneToMany(mappedBy = "standard")
    List<StandardCampTheme> standardCampThemes = new ArrayList<>();

    @Builder
    public Standard(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
