package com.aor.journey.model.menu;

import java.util.Arrays;

public class ShopMenu extends Menu {
    public ShopMenu() { super(Arrays.asList("Buy Lives (5 coins)", "Buy Traps (10 coins)", "Close")); }
    public boolean isSelectedLives() {return isSelected(0);}
    public boolean isSelectedTraps() {return isSelected(1);}
    public boolean isSelectedClose() {return isSelected(2);}
}
