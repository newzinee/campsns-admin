package com.campfour.domain;

import javax.persistence.*;

/**
 * @author yj
 * @version 0.1.0
 * @since 2020/12/06
 */
@Entity
public class StandardCampTheme {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Standard standard;

    private CampTheme campTheme;
}
