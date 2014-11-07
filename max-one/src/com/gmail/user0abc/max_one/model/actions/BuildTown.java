package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.buildings.BuildingType;
import com.gmail.user0abc.max_one.model.buildings.Town;
import com.gmail.user0abc.max_one.model.terrain.MapTile;
import com.gmail.user0abc.max_one.model.units.Unit;

/**
 * Created by Sergey
 * at 11/4/14 11:12 PM
 */
public class BuildTown extends UnitAction {

    @Override
    public ActionType getActionType() {
        return ActionType.BUILD_TOWN;
    }

    @Override
    public boolean isAvailable(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        return selectedTile.building == null;
    }

    @Override
    public void onActivate(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        Town newTown = new Town();
        newTown.buildingType = BuildingType.TOWN;
        newTown.owner = selectedUnit.owner;
        selectedTile.unit = null;
    }

    @Override
    public void onCancel(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        // n/a
    }

    @Override
    public void onContinue(GameContainer game, MapTile selectedTile, Unit selectedUnit) {
        // n/a
    }
}
