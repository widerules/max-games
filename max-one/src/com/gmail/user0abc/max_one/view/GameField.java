package com.gmail.user0abc.max_one.view;

import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.gmail.user0abc.max_one.GameController;
import com.gmail.user0abc.max_one.R;
import com.gmail.user0abc.max_one.model.actions.ActionType;
import com.gmail.user0abc.max_one.util.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey
 * at 10/31/14 8:06 PM
 */
public class GameField extends SurfaceView {
    private List<MotionEvent> recordedEvents = new ArrayList<>();
    private final SurfaceHolder holder;
    private Bitmap grass, water, worker, selection, tree, coin, apple, tint;
    private Bitmap endTurn, actionPlate, actionMove, actionWait, actionRemove, actionClean, actionAttack,
            actionDelete, actionTown, actionFarm, actionTrade;
    float mapOffsetX = 0, mapOffsetY = 0;
    Integer selectedTileX, selectedTileY;
    private GameController gameController;

    public GameField(Context context) {
        super(context);
        gameController = (GameController) getContext();
        holder = getHolder();
        setClickable(true);
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                //TODO implement method
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                //TODO implement method
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                //TODO implement method
            }
        });
        loadImages();
    }

    private void loadImages() {
        grass = BitmapFactory.decodeResource(getResources(), R.drawable.grass);
        water = BitmapFactory.decodeResource(getResources(), R.drawable.water);
        worker = BitmapFactory.decodeResource(getResources(), R.drawable.worker);
        selection = BitmapFactory.decodeResource(getResources(), R.drawable.selected);
        tree = BitmapFactory.decodeResource(getResources(), R.drawable.tree);
        coin = BitmapFactory.decodeResource(getResources(), R.drawable.coin);
        apple = BitmapFactory.decodeResource(getResources(), R.drawable.apple);
        tint = BitmapFactory.decodeResource(getResources(), R.drawable.tint);
        actionPlate = BitmapFactory.decodeResource(getResources(), R.drawable.action_plate);
        endTurn = BitmapFactory.decodeResource(getResources(), R.drawable.end_turn);
        actionMove = BitmapFactory.decodeResource(getResources(), R.drawable.walk);
        actionWait = BitmapFactory.decodeResource(getResources(), R.drawable.wait);
        actionRemove = BitmapFactory.decodeResource(getResources(), R.drawable.remove_building);
        actionClean = BitmapFactory.decodeResource(getResources(), R.drawable.clean_terrain);
        actionAttack = BitmapFactory.decodeResource(getResources(), R.drawable.attack);
        actionDelete = BitmapFactory.decodeResource(getResources(), R.drawable.delete_unit);
        actionTown = BitmapFactory.decodeResource(getResources(), R.drawable.town);
        actionFarm = BitmapFactory.decodeResource(getResources(), R.drawable.farm);
        actionTrade = BitmapFactory.decodeResource(getResources(), R.drawable.trade);
    }

    public void redraw() {
        Canvas canvas = holder.lockCanvas(null);
        draw(canvas);
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event == null) {
            return false;
        }
        Logger.log("Event: " + event.toString());


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                recordedEvents = new ArrayList<>();
                recordedEvents.add(event);
                break;
            case MotionEvent.ACTION_UP:
                recordedEvents.add(event);
                recognizeSelect(event);
                break;
            case MotionEvent.ACTION_MOVE:
                recordedEvents.add(event);
                scrollMap(event);
                break;
            default:
                recordedEvents.add(event);
        }
        return true;
    }

    private void recognizeSelect(MotionEvent event) {
        for (int i = 0; i < recordedEvents.size(); i++) {
            Logger.log("recorded events[" + i + "]=" + recordedEvents.get(i).getAction() + " " + recordedEvents.get(i).getX() + ", " + recordedEvents.get(i).getY());
        }
        if (recordedEvents.size() == 2) {
            selectedTileX = (int) ((event.getX() - mapOffsetX) / grass.getWidth());
            selectedTileY = (int) ((event.getY() - mapOffsetY) / grass.getHeight());
            gameController.onTileSelect(gameController.getMap()[selectedTileX][selectedTileY]);
            redraw();
        }
    }

    private void scrollMap(MotionEvent event) {
        if (event.getHistorySize() > 0) {
            float endX = event.getX();
            float endY = event.getY();
            float startX = event.getHistoricalX(0);
            float startY = event.getHistoricalY(0);
            Canvas canvas = getHolder().lockCanvas(null);
            mapOffsetX += endX - startX;
            mapOffsetY += endY - startY;
            draw(canvas);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.translate(mapOffsetX, mapOffsetY);
        drawMap(canvas);
        canvas.restore();
        drawInfo(canvas);
        drawUnitInfo(canvas);
        drawEndTurn(canvas);
        fixOffset();
    }

    private void drawEndTurn(Canvas canvas) {
        float x = canvas.getWidth() - 4 - endTurn.getWidth();
        float y = canvas.getHeight() - 4 - endTurn.getHeight();
        canvas.drawBitmap(endTurn, x, y, null);
    }

    private void drawUnitInfo(Canvas canvas) {
        List<ActionType> availableActions = gameController.getAvailableActions();
        if (availableActions == null) return;
        for (int i = 0; i < availableActions.size(); i++) {
            float x = (float) 4 + i * actionPlate.getWidth();
            float y = (float) canvas.getHeight() - 4 - coin.getHeight();
            canvas.drawBitmap(actionPlate, x, y, null);
            canvas.drawBitmap(getActionImage(availableActions.get(i)), x, y, null);
        }
    }

    private Bitmap getActionImage(ActionType availableAction) {
        Bitmap actionImage = null;
        switch (availableAction) {
            case MOVE_ACTION:
                return actionMove;
            case WAIT_ACTION:
                return actionWait;
            case ATTACK_TILE:
                return actionAttack;
            case BUILD_FARM:
                return actionFarm;
            case BUILD_POST:
                return actionTrade;
            case BUILD_TOWN:
                return actionTown;
            case CLEAN_TERRAIN:
                return actionClean;
            case DELETE_UNIT:
                return actionDelete;
            case REMOVE_BUILDING:
                return actionRemove;
            default:
                return null;
        }
    }

    public void drawInfo(Canvas canvas) {
        //apples
        for (int i = 0; i < gameController.getApples(); i++) {
            float x = (float) 4 + i * apple.getWidth();
            float y = 4;
            canvas.drawBitmap(tint, x, y, null);
            canvas.drawBitmap(apple, x, y, null);
        }
        //gold
        for (int i = 0; i < gameController.getGold(); i++) {
            float x = (float) canvas.getWidth() - 4 - (i + 1) * coin.getWidth();
            float y = 4;
            canvas.drawBitmap(tint, x, y, null);
            canvas.drawBitmap(coin, x, y, null);
        }
    }

    private void fixOffset() {
        //TODO implement method
//        float maxOffsetY = canvas.getWidth() - getWidth();
//        float maxOffsetX = canvas.getHeight() - getHeight();
//        if(mapOffsetY < 0) maxOffsetY = 0;
//        if(mapOffsetY > maxOffsetY) mapOffsetY = maxOffsetY;
//        if(mapOffsetX < 0) mapOffsetX = 0;
//        if(mapOffsetX > maxOffsetX) mapOffsetX = maxOffsetX;
    }

    private void drawMap(Canvas canvas) {

        canvas.drawColor(Color.BLACK);
        for (int posX = 0; posX < gameController.getMap().length; posX++) {
            for (int posY = 0; posY < gameController.getMap()[posX].length; posY++) {
                // draw tiles
                float x = posX * grass.getWidth();
                float y = posY * grass.getHeight();
                switch (gameController.getMap()[posX][posY].terrainType) {
                    case GRASS:
                        canvas.drawBitmap(grass, x, y, null);
                        break;
                    case WATER:
                        canvas.drawBitmap(water, x, y, null);
                        break;
                    case TREE:
                        canvas.drawBitmap(grass, x, y, null);
                        canvas.drawBitmap(tree, x, y, null);
                        break;
                }
                // draw units
                if (gameController.getMap()[posX][posY].unit != null) {
                    switch (gameController.getMap()[posX][posY].unit.getUnitType()) {
                        case WORKER:
                            canvas.drawBitmap(worker, x, y, null);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if (selectedTileY != null && selectedTileX != null) {
            float x = selectedTileX * grass.getWidth();
            float y = selectedTileY * grass.getHeight();
            canvas.drawBitmap(selection, x, y, null);
        }
    }

}
