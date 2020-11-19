package com.campfour.repository;

import com.campfour.domain.CampTheme;
import com.campfour.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    List<Theme> findByCampTheme(CampTheme campTheme);
}
