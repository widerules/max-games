package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.exceptions.IllegalMove;
import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.terrain.MapTile;
import com.gmail.user0abc.max_one.model.units.Unit;

/**
 * Created by Sergey
 * at 11/5/14 11:09 PM
 */
public class WalkAction extends UnitAction {

    @Override
    public AbilityType getActionType() {
        return null;  //TODO implement method
    }

    @Override
    public boolean isAvailable(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        return false;  //TODO implement method
    }

    @Override
    public void execute(GameContainer game, MapTile selectedTile, Unit selectedUnit) throws IllegalMove {
        //TODO implement method
    }

}
