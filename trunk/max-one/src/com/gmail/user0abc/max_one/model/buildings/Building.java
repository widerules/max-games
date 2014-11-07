package com.gmail.user0abc.max_one.model.buildings;

import com.gmail.user0abc.max_one.model.Player;
import com.gmail.user0abc.max_one.model.actions.ActionType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sergii.ivanov on 10/24/2014.
 */
public class Building implements Serializable {
    public BuildingType buildingType;
    public Player owner;

    public List<ActionType> allActions() {
        return new ArrayList<>(0);  //TODO - implement method
    }
}