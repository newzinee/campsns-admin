package com.campfour.controller;

import com.campfour.config.KakaoConfig;
import com.campfour.domain.Camp;
import com.campfour.repository.CampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CampController {

    private final CampRepository campRepository;
    private final KakaoConfig kakaoConfig;

    @GetMapping("/camps")
    public String camp(Model model, Pageable pageable) {

        model.addAttribute("camps", campRepository.findAll(pageable));

        return "camp/campList";
    }

    @GetMapping("/camps/{id}")
    public String campDetail(@PathVariable Long id, Model model, Pageable pageable) {
        Camp camp = campRepository.findById(id).orElseThrow();

        model.addAttribute("prev", campRepository.findPrevById(id));
        model.addAttribute("next", campRepository.findNextById(id));
        model.addAttribute("camp", camp);
        model.addAttribute("page", pageable);
        model.addAttribute("kakaoConfig", kakaoConfig);
        return "camp/campDetail";
    }
}

