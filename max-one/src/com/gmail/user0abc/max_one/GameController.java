package com.gmail.user0abc.max_one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.gmail.user0abc.max_one.model.GameContainer;
import com.gmail.user0abc.max_one.model.Player;
import com.gmail.user0abc.max_one.model.actions.UnitAction;
import com.gmail.user0abc.max_one.model.buildings.Building;
import com.gmail.user0abc.max_one.model.terrain.MapTile;
import com.gmail.user0abc.max_one.model.units.Unit;
import com.gmail.user0abc.max_one.util.GameStorage;
import com.gmail.user0abc.max_one.view.GameField;

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
        gameField.setMap(game.map);
        setContentView(gameField);
        currentPlayer = game.players.get(0);
    }

    public void onTileSelect(MapTile tile){
        if(selectedUnit == null && tile.unit != null){

        }
    }

    public void endTurn(){

    }



}
