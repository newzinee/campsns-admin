package com.campfour.repository;

import com.campfour.domain.Address;
import com.campfour.domain.Camp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Transactional
@SpringBootTest
class CampRepositoryTest {

    @Autowired
    CampRepository campRepository;

    @Test
    public void findPrevById() {

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

        // when
        Long id = camp3.getId();
        Camp prevCamp = campRepository.findPrevById(id);

        // then
        assertThat(prevCamp.getId()).isLessThan(id);
        assertThat(prevCamp.getId()).isEqualTo(camp2.getId());

    }

    @Test
    public void findPrevNullById() {

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

        // when
        Long id = camp1.getId();
        Camp prevCamp = campRepository.findPrevById(id);

        // then
        assertThatNullPointerException().isThrownBy(() -> {
            assertThat(prevCamp.getId()).isLessThan(id);
        });
    }

    @Test
    public void findPNextById() {

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

        // when
        Long id = camp2.getId();
        Camp nextCamp = campRepository.findNextById(id);

        // then
        assertThat(nextCamp.getId()).isGreaterThan(id);
        assertThat(nextCamp.getId()).isEqualTo(camp3.getId());

    }

    @Test
    public void findNextNullById() {

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

        // when
        Long id = camp3.getId();
        Camp nextCamp = campRepository.findNextById(id);

        // then
        assertThatNullPointerException().isThrownBy(() -> {
            assertThat(nextCamp.getId()).isGreaterThan(id);
        });
    }
}