package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.exceptions.IllegalMove;
import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.terrain.MapTile;
import com.gmail.user0abc.max_one.model.units.Unit;

import java.io.Serializable;

/**
 * Created by Sergey
 * at 11/4/14 11:06 PM
 */
public abstract class UnitAction implements Serializable {

    public abstract AbilityType getActionType();

    public abstract boolean isAvailable(GameContainer game, MapTile selectedTile, Unit selectedUnit);

    /*
    * called when action icon tapped
    * parameters should be saved within the action
    * */
    public abstract void onActivate(GameContainer game, MapTile selectedTile, Unit selectedUnit);
    /*
    * Called when user defined details on action (like tile for move or attack)
    * Accepts selected tile
    * */
    public abstract void onExecute(MapTile selectedTile);

    /*
    * Called when user cancels action
    * */
    public abstract void onCancel();

    /*
    * called when unit continues action automatically on the next turn
    * */
    public abstract void onContinue(GameContainer game, MapTile selectedTile, Unit selectedUnit);

}
