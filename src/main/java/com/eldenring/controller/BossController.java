package com.eldenring.controller;

import com.eldenring.controller.dtos.BossAndBuildsDTO;
import com.eldenring.model.Bosses;
import com.eldenring.model.Builds;
import com.eldenring.repository.BossRepository;
import com.eldenring.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
// ALLOWS TO SEARCH FOR A BOSS BY NAME AND RETURN RECOMMENDED BUILDS
// BASICALLY THE METHOD LEADS WITH REQUISITION GET,SO IT  SEARCH FOR THE BOSS IN DATABASE, USES THE SERVICE
// TO FIND THE BEST BUILD FOR THAT BOSS, THEN CREATE A REPONSE USING DTO
@RestController
@RequestMapping("/api/bosses")
public class BossController {
    private final BossRepository bossRepository;
    private final BossService bossService;

    /**
     * Boss controller constructor, responsible for managing requests related to bosses and their recommended builds.
     *
     * @param bossRepository Repository for accessing boss data.
     * @param bossService Service for processing business logic related to bosses.
     */

    @Autowired
    public BossController(BossRepository bossRepository, BossService bossService){
        this.bossRepository = bossRepository;
        this.bossService = bossService;
    }

    /**
     * Returns information about a boss and the recommended builds to face it.
     *
     * @param nome Name of the boss to be searched in the API.
     * @return ResponseEntity containing a DTO with the boss data and its recommended builds.
     */

    @GetMapping("/{nome}")
    public ResponseEntity<BossAndBuildsDTO> getBossAndBuilds(@PathVariable String nome){
        Optional<Bosses> bossOpt = bossRepository.findByNome(nome);

        if (!bossOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Bosses boss = bossOpt.get();

        List<Builds> recommendedBuilds = bossService.getRecomendedBuilds(boss);

        BossAndBuildsDTO response = new BossAndBuildsDTO(boss, recommendedBuilds);

        return ResponseEntity.ok(response);
    }
}
