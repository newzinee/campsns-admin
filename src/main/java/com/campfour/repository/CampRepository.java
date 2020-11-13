package com.campfour.repository;

import com.campfour.domain.Camp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CampRepository extends JpaRepository<Camp, Long> {

    @Query("select c from Camp c where c.id = (select max(cc.id) from Camp cc where cc.id < :id)")
    Camp findPrevById(Long id);

    @Query("select c from Camp c where c.id = (select min(cc.id) from Camp cc where cc.id > :id)")
    Camp findNextById(Long id);
}
