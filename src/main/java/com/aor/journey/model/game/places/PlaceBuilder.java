package com.aor.journey.model.game.places;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public abstract class PlaceBuilder {
    protected final List<String> lines;

    public PlaceBuilder(){
        lines = new ArrayList<>();
    }
    public PlaceBuilder(String placeName) throws IOException {
        URL resource = PlaceBuilder.class.getResource("/places/" + placeName + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    public abstract Place createPlace();

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    protected int getHeight() {
        return lines.size();
    }
}