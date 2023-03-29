package com.aor.journey.GUI;

import com.aor.journey.model.game.Position;

import java.io.IOException;

public interface GUI {
    public static final int WIDTH = 25;
    public static final int HEIGHT = 25;
    ACTION getNextAction() throws IOException;
    void setupGameFrame();
    void setupGameFrame(String bgColour);
    void drawElement(Position position, char c, String colour);

    void drawText(Position position, String text, String color);

    void drawColour(Position position, String colour);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, INTERACT, USE}
}
