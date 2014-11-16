package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.exceptions.IllegalMove;
import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.terrain.MapTile;
import com.gmail.user0abc.max_one.model.units.Unit;

/**
 * Created by Sergey
 * at 11/12/14 10:14 PM
 */
public class RemoveBuildingAction extends UnitAction {

    @Override
    public AbilityType getActionType() {
        return null;  //TODO implement method
    }

    @Override
    public boolean isAvailable(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        return false;  //TODO implement method
    }

    @Override
    public void onActivate(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        //TODO implement method
    }

    @Override
    public void onExecute(MapTile selectedTile) {
        //TODO implement method
    }

    @Override
    public void onCancel() {
        //TODO implement method
    }

    @Override
    public void onContinue(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        //TODO implement method
    }
}
