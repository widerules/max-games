package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.MapTile;
import com.gmail.user0abc.max_one.model.Unit;

/**
 * Created by Sergey
 * at 11/4/14 11:12 PM
 */
public class BuildCity extends UnitAction {
    @Override
    public int getActionCode() {
        return 1;  //TODO implement method
    }

    @Override
    public boolean isAvailable(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        return false;  //TODO implement method
    }
}
