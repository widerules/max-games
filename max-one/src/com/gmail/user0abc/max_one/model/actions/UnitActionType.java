package com.gmail.user0abc.max_one.model.actions;

import com.gmail.user0abc.max_one.R;

/**
 * Created by Sergey
 * at 11/6/14 12:50 AM
 */
public enum UnitActionType{
    MOVE_ACTION("Move to", R.drawable.walk),
    WAIT_ACTION("Wait",R.drawable.wait),
    REMOVE_BUILDING("Destroy building",R.drawable.remove_building),
    CLEAN_TERRAIN("Clean terrain",R.drawable.clean_terrain),
    ATTACK_TILE("Attack",R.drawable.attack),
    DELETE_UNIT("Delete unit",R.drawable.delete_unit),
    BUILD_TOWN("Build town",R.drawable.town),
    BUILD_FARM("Build farm",R.drawable.farm),
    BUILD_POST("Build post",R.drawable.trade);

    private String name;
    private int icon;

    UnitActionType(String name, int icon){
        this.name = name;
        this.icon = icon;
    }
    public int getIcon(){
        return icon;
    }
    public String getName(){
        return name;
    }
}
