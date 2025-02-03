package com.eldenring.service;

import com.eldenring.model.Bosses;
import com.eldenring.model.Builds;
import com.eldenring.repository.BuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//SERVICE THAT IMPLEMENTS THE RECOMMENDATION LOGIC BASED IN BOSSES WEAKNESS AND RESISTENCES
@Service
public class BossService {
    private final BuildRepository buildRepository;

    /**
     * Constructor that injects the build repository.
     *
     * @param buildRepository Repository that accesses builds in the database.
     */

    @Autowired
    public BossService(BuildRepository buildRepository){
        this.buildRepository = buildRepository;
    }

    /**
     * Returns the 2 best builds to face a boss based on its weaknesses and resistances.
     *
     * @param boss The boss to be analyzed.
     * @return A list containing the 2 most recommended builds.
     */

    public List<Builds> getRecomendedBuilds(Bosses boss){
        List<String> tiposDeDano = new ArrayList<>();
        if (boss.getFraquezas().contains("Magia")) {
            tiposDeDano.add("Mágico");
        }
        if (boss.getFraquezas().contains("Fogo")) {
            tiposDeDano.add("Fogo");
        }
        if (boss.getFraquezas().contains("Sangramento")) {
            tiposDeDano.add("Sangramento");
        }
        if (boss.getFraquezas().contains("Gelo")) {
            tiposDeDano.add("Gelo");
        }
        if (boss.getFraquezas().contains("Congelamento")) {
            tiposDeDano.add("Gelo");
        }
        if (boss.getFraquezas().contains("Físico")) {
            tiposDeDano.add("Físico");
        }
        if (boss.getFraquezas().contains("Sagrado")) {
            tiposDeDano.add("Sagrado");
        }
        if (boss.getFraquezas().contains("Magia Negra")) {
            tiposDeDano.add("Magia Negra");
        }
        List<Builds> builds = buildRepository.findBuildsByTipoDanoIn(tiposDeDano);
        List<Builds> recommendedBuilds = new ArrayList<>();

        for(Builds build : builds){
            int rating = calculateRating(build, boss);

            if(rating > 0){
                recommendedBuilds.add(build);
            }
        }

        recommendedBuilds.sort((build1, build2) -> Integer.compare(
                calculateRating(build2, boss), calculateRating(build1, boss)));
        return recommendedBuilds.stream().limit(2).collect(Collectors.toList());
    }

    /**
     * Calculates how effective a build is against a boss.
     *
     * @param build The build to be evaluated.
     * @param boss The boss the build will be used against.
     * @return An integer value representing the effectiveness of the build (rating).
     */

    private int calculateRating(Builds build, Bosses boss){
        int rating = 0;

        if(build.getTipoDano().equals("Mágico") && boss.getFraquezas().contains("Magia")){
            rating+=2;
        }

        if(build.getTipoDano().equals("Sangramento") && boss.getFraquezas().contains("Sangramento")){
            rating+=2;
        }

        if(build.getTipoDano().equals("Gelo") && boss.getFraquezas().contains("Gelo")){
            rating+=2;
        }

        if(build.getTipoDano().equals("Gelo") && boss.getFraquezas().contains("Congelamento")){
            rating+=2;
        }

        if(build.getTipoDano().equals("Sagrado") && boss.getFraquezas().contains("Sagrado")){
            rating+=2;
        }

        if(build.getTipoDano().equals("Magia Negra") && boss.getFraquezas().contains("Magia Negra")){
            rating+=2;
        }

        if(build.getTipoDano().equals("Mágico") && boss.getFraquezas().contains("Magia")){
            rating+=2;
        }

        if(build.getTipoDano().equals("Fogo") && boss.getFraquezas().contains("Fogo")){
            rating+=2;
        }

        if(build.getTipoDano().equals("Físico") && boss.getFraquezas().contains("Físico")){
            rating+=2;
        }


        if(build.getTipoDano().equals("Gelo") && boss.getResistencias().contains("Gelo")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Magia") && boss.getResistencias().contains("Magia")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Mágico") && boss.getResistencias().contains("Magia")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Magia Negra") && boss.getResistencias().contains("Magia negra")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Elétrico") && boss.getResistencias().contains("Relâmpago")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Gelo") && boss.getResistencias().contains("Gelo")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Sagrado") && boss.getResistencias().contains("Sagrado")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Fogo") && boss.getResistencias().contains("Fogo")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Físico") && boss.getResistencias().contains("Físico")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Veneno") && boss.getResistencias().contains("Veneno")){
            rating-=1;
        }

        if(build.getTipoDano().equals("Sangramento") && boss.getResistencias().contains("Sangramento")){
            rating-=1;
        }

        return rating;
    }
}
