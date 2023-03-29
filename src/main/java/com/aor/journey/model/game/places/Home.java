package com.aor.journey.model.game.places;

import com.aor.journey.model.game.elements.Trophy;

import java.util.ArrayList;
import java.util.List;

public class Home extends Place{
    private List<Trophy> trophies = new ArrayList<>();

    public void setTrophies(List<Trophy> trophies) {
        this.trophies = trophies;
    }
    public List<Trophy> getTrophies() {
        return trophies;
    }
}
