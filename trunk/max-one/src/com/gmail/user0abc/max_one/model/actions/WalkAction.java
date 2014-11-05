package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.terrain.MapTile;
import com.gmail.user0abc.max_one.model.units.Unit;

/**
 * Created by Sergey
 * at 11/5/14 11:09 PM
 */
public class WalkAction extends UnitAction {
    @Override
    public UnitActionType getActionType() {
        return UnitActionType.MOVE_ACTION;
    }

    @Override
    public boolean isAvailable(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        return selectedUnit.getActionPoints() > 0;
    }

    @Override
    public void onActivate(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        // TODO draw available movements
    }

    @Override
    public void onCancel(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        //TODO implement method
    }

    @Override
    public void onContinue(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        //TODO implement method
    }
}
