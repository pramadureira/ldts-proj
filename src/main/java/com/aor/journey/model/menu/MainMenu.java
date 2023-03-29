package com.aor.journey.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu{

    public MainMenu() {
        super(Arrays.asList("Start","Help", "Quit"));
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }
    public boolean isSelectedHelp() {
        return isSelected(1);
    }
    public boolean isSelectedQuit() {return isSelected(2);}


}
