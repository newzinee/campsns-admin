package com.campfour.repository;

import com.campfour.domain.Address;
import com.campfour.domain.Camp;
import com.campfour.domain.CampTheme;
import com.campfour.domain.Theme;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class ThemeRepositoryTest {

    @Autowired
    ThemeRepository themeRepository;

    @Autowired
    CampRepository campRepository;

    @Test
    public void findByCampTheme() {
        // given
        Address address = Address.builder()
                .jibunAddr("지번 주소")
                .roadAddr("도로명 주소").build();

        Camp camp1 = Camp.builder().name("테스트1").address(address).build();
        Camp camp2 = Camp.builder().name("테스트2").address(address).build();
        Camp camp3 = Camp.builder().name("테스트3").address(address).build();
        campRepository.save(camp1);
        campRepository.save(camp2);
        campRepository.save(camp3);

        Theme theme1 = Theme.builder().camp(camp1).campTheme(CampTheme.COUPLE).build();
        Theme theme2 = Theme.builder().camp(camp1).campTheme(CampTheme.SEA).build();

        Theme theme3 = Theme.builder().camp(camp2).campTheme(CampTheme.COUPLE).build();
        Theme theme4 = Theme.builder().camp(camp2).campTheme(CampTheme.MOUNTAIN).build();

        themeRepository.save(theme1);
        themeRepository.save(theme2);
        themeRepository.save(theme3);
        themeRepository.save(theme4);


        // when
        List<Theme> coupleCamps = themeRepository.findByCampTheme(CampTheme.COUPLE);
        List<Theme> seaCamps = themeRepository.findByCampTheme(CampTheme.SEA);
        List<Theme> mountainCamps = themeRepository.findByCampTheme(CampTheme.MOUNTAIN);

        // then
        // 1. theme 에서 camp 찾기
        assertThat(coupleCamps).extracting("camp", Camp.class).containsOnly(camp1, camp2);
        assertThat(seaCamps).extracting("camp", Camp.class).containsOnly(camp1);
        assertThat(mountainCamps).extracting("camp", Camp.class).containsOnly(camp2);
    }
}