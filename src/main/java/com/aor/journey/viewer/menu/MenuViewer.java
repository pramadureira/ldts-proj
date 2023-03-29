package com.aor.journey.viewer.menu;

import com.aor.journey.model.menu.Menu;
import com.aor.journey.viewer.Viewer;

public abstract class MenuViewer<T extends Menu> extends Viewer<T> {
    public MenuViewer(T menu) {
        super(menu);
    }
}
