package com.gmail.user0abc.max_one.model.units;

import com.gmail.user0abc.max_one.model.actions.UnitAction;
import com.gmail.user0abc.max_one.model.actions.UnitActionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergey
 * at 11/3/14 10:27 PM
 */
public class Worker extends Unit {

    @Override
    public List<UnitActionType> allActions() {
        List<UnitActionType> actions = new ArrayList<>();
        actions.add(UnitActionType.MOVE_ACTION);
        actions.add(UnitActionType.WAIT_ACTION);
        actions.add(UnitActionType.BUILD_FARM);
        actions.add(UnitActionType.BUILD_POST);
        actions.add(UnitActionType.BUILD_TOWN);
        actions.add(UnitActionType.REMOVE_BUILDING);
        actions.add(UnitActionType.CLEAN_TERRAIN);
        actions.add(UnitActionType.DELETE_UNIT);
        return actions;
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.WORKER;
    }
}
