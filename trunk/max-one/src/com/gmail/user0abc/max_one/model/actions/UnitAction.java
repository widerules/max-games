package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.R;
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

    public abstract UnitActionType getActionType();

    public abstract boolean isAvailable(GameContainer game, MapTile selectedTile, Unit selectedUnit);

    /*
    * called when action icon tapped
    * */
    public abstract void onActivate(GameContainer game, MapTile selectedTile, Unit selectedUnit) throws IllegalMove;

    public abstract void onCancel(GameContainer game, MapTile selectedTile, Unit selectedUnit);

    /*
    * called when unit continues action automatically
    * */
    public abstract void onContinue(GameContainer game, MapTile selectedTile, Unit selectedUnit) throws IllegalMove;

}
