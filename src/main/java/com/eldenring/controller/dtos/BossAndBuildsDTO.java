package com.eldenring.controller.dtos;

import com.eldenring.model.Bosses;
import com.eldenring.model.Builds;

import java.util.List;
// DTO, USED TO STRUCTURE THE DATA THAT THE API WILL SEND AS RESPONSE
public class BossAndBuildsDTO {
    private Bosses boss;
    private List<Builds> builds;

    public BossAndBuildsDTO(Bosses boss, List<Builds> builds) {
        this.boss = boss;
        this.builds = builds;
    }

    public Bosses getBoss() {
        return boss;
    }

    public void setBoss(Bosses boss) {
        this.boss = boss;
    }

    public List<Builds> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Builds> builds) {
        this.builds = builds;
    }
}
