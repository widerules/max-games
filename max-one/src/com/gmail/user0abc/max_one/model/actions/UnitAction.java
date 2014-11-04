package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.MapTile;
import com.gmail.user0abc.max_one.model.Unit;

/**
 * Created by Sergey
 * at 11/4/14 11:06 PM
 */
public abstract class UnitAction {

    public static int MOVE = 1;
    public static int WAIT = 2;
    public static int REMOVE_BUILDING = 3;
    public static int CLEAN_TERRAIN = 4;
    public static int DELETE_UNIT = 9;
    public static int BUILD_CITY = 10;
    public static int BUILD_FARM = 11;
    public static int BUILD_POST = 12;

    public abstract int getActionCode();

    public abstract boolean isAvailable(GameContainer game, MapTile selectedTile, Unit selectedUnit);

}
