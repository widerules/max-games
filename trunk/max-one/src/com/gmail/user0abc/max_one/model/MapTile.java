package com.gmail.user0abc.max_one.model;

import com.gmail.user0abc.max_one.model.units.Unit;

import java.io.Serializable;

/**
 * Created by sergii.ivanov on 10/24/2014.
 */
public class MapTile implements Serializable {
    public TerrainType terrainType;
    public boolean explored;
    public Building building;
    public Unit unit;
    public int x;
    public int y;
}
