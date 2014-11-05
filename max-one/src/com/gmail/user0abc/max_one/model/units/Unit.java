package com.gmail.user0abc.max_one.model.units;

import com.gmail.user0abc.max_one.model.Player;
import com.gmail.user0abc.max_one.model.actions.UnitAction;
import com.gmail.user0abc.max_one.model.actions.UnitActionType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sergii.ivanov on 10/24/2014.
 */
public abstract class Unit implements Serializable {
    public UnitType unitType;
    public Player owner;
    public UnitAction currentAction;
    private int actionPoints;

    public abstract List<UnitActionType> allActions();

    public int getActionPoints() {
        return actionPoints;
    }
}
