package com.campfour.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Theme {

    @Id @GeneratedValue
    @Column(name = "theme_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "camp_id")
    private Camp camp;

    @Enumerated(EnumType.STRING)
    private CampTheme campTheme;

    @Builder
    public Theme(Camp camp, CampTheme campTheme) {
        this.camp = camp;
        this.campTheme = campTheme;
    }

    public Camp getCamp() {
        return camp;
    }
}
