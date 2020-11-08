package com.campfour.config;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter
@Validated
@Configuration
public class KakaoConfig {

    @NotNull
    @Value("${kakao.key.js}")
    private String jsKey;
}
