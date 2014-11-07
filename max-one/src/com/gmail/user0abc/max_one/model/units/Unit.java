package com.gmail.user0abc.max_one.model.units;

import com.gmail.user0abc.max_one.model.Player;
import com.gmail.user0abc.max_one.model.actions.ActionType;
import com.gmail.user0abc.max_one.model.actions.UnitAction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sergii.ivanov on 10/24/2014.
 */
public abstract class Unit implements Serializable {
    public Player owner;
    public UnitAction currentAction;
    private int actionPoints;

    public abstract List<ActionType> allActions();

    public abstract UnitType getUnitType();

    public int getActionPoints() {
        return actionPoints;
    }
}
