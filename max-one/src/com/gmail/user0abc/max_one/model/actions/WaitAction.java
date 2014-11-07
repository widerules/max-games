package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.terrain.MapTile;
import com.gmail.user0abc.max_one.model.units.Unit;

/**
 * Created by Sergey
 * at 11/5/14 9:29 PM
 */
public class WaitAction extends UnitAction {

    @Override
    public ActionType getActionType() {
        return ActionType.WAIT_ACTION;
    }

    @Override
    public boolean isAvailable(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        return true;
    }

    @Override
    public void onActivate(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        selectedUnit.currentAction = this;
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
