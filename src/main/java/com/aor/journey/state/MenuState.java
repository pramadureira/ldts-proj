package com.aor.journey.state;

import com.aor.journey.model.menu.Menu;

public abstract class MenuState<T extends Menu> extends State<T> {
    public MenuState(T model) {
        super(model);
    }
}
