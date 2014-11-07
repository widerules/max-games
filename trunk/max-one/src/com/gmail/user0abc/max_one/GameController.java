package com.gmail.user0abc.max_one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.Player;
import com.gmail.user0abc.max_one.model.actions.ActionType;
import com.gmail.user0abc.max_one.model.actions.UnitAction;
import com.gmail.user0abc.max_one.model.buildings.Building;
import com.gmail.user0abc.max_one.model.terrain.MapTile;
import com.gmail.user0abc.max_one.model.units.Unit;
import com.gmail.user0abc.max_one.util.GameStorage;
import com.gmail.user0abc.max_one.view.GameField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey
 * at 10/24/14 6:43 PM
 */
public class GameController extends Activity {

    private GameContainer game;
    private GameField gameField;
    private Player currentPlayer;
    private Unit selectedUnit;
    private Building selectedBuilding;
    private UnitAction selectedAction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        game = GameStorage.getStorage().getGameContainer();
        gameField = new GameField(this);
        setContentView(gameField);
        currentPlayer = game.players.get(0);
    }

    public void startTurn() {
        gameField.redraw();
    }

    public MapTile[][] getMap() {
        return game.map;
    }

    public int getApples() {
        return 5;
    }

    public int getGold() {
        return 5;
    }

    public void onTileSelect(MapTile tile) {

        if (selectedUnit == null) { // no unit selected
            if (tile.unit != null) { // tile has unit
                selectedUnit = tile.unit;
                selectedBuilding = null;
            }else{
                if(tile.building != null){// there is a building
                    selectedBuilding = tile.building;
                }
            }
        } else { // unit selected
            if (selectedUnit.equals(tile.unit)) { // same unit second click
                if (tile.building != null) { // try building
                    selectedUnit = null;
                    selectedBuilding = tile.building;
                }else{ // no building - deselect
                    selectedUnit = null;
                }
            } else { // not the same unit
                if(tile.unit == null){ // no new unit to select
                    selectedUnit = null;
                }else{ // another unit
                    selectedUnit = tile.unit;
                }
            }
        }

    }

    public void endTurn() {

    }


    public List<ActionType> getAvailableActions() {
        if(selectedUnit != null){
            return selectedUnit.allActions();
        }
        if(selectedBuilding != null){
            return selectedBuilding.allActions();
        }
        return null;
    }
}