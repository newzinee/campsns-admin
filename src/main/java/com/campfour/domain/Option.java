package com.campfour.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 편의시설 같은거
 * 전기, 화장실, 놀이터.. 이런거
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Option {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;
    private String value;    // 이름
    private String code;    // 앱에 저장된 이미지 이름

    @Builder
    public Option(String value, String code) {
        this.value = value;
        this.code = code;
    }
}
