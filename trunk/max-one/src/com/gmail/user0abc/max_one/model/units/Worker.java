package com.gmail.user0abc.max_one.model.units;

import com.gmail.user0abc.max_one.model.actions.ActionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey
 * at 11/3/14 10:27 PM
 */
public class Worker extends Unit {

    @Override
    public List<ActionType> allActions() {
        List<ActionType> actions = new ArrayList<>();
        actions.add(ActionType.MOVE_ACTION);
        actions.add(ActionType.WAIT_ACTION);
        actions.add(ActionType.BUILD_FARM);
        actions.add(ActionType.BUILD_POST);
        actions.add(ActionType.BUILD_TOWN);
        actions.add(ActionType.REMOVE_BUILDING);
        actions.add(ActionType.CLEAN_TERRAIN);
        actions.add(ActionType.DELETE_UNIT);
        return actions;
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.WORKER;
    }
}
