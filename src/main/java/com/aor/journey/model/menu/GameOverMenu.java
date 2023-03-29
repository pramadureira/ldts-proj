package com.aor.journey.model.menu;

import java.util.Arrays;

public class GameOverMenu extends Menu{
    public GameOverMenu(){
        super(Arrays.asList("Back", "Quit"));
    }
    public boolean isSelectedBack() {return isSelected(0);}
    public boolean isSelectedQuit() {return isSelected(1);}
}
