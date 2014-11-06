package com.gmail.user0abc.max_one.view;

import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.gmail.user0abc.max_one.GameController;
import com.gmail.user0abc.max_one.R;
import com.gmail.user0abc.max_one.model.terrain.MapTile;
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
    private Bitmap grass, water, worker, selection, tree, coin, apple;
    float mapOffsetX = 0, mapOffsetY = 0;
    Integer selectedTileX, selectedTileY;
    private GameController gameController;

    public GameField(Context context) {
        super(context);
        gameController = (GameController)getContext();
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
        grass = BitmapFactory.decodeResource(getResources(), R.drawable.grass);
        water = BitmapFactory.decodeResource(getResources(),R.drawable.water);
        worker = BitmapFactory.decodeResource(getResources(),R.drawable.worker);
        selection = BitmapFactory.decodeResource(getResources(),R.drawable.selected);
        tree = BitmapFactory.decodeResource(getResources(),R.drawable.tree);
        coin = BitmapFactory.decodeResource(getResources(),R.drawable.coin);
        apple = BitmapFactory.decodeResource(getResources(),R.drawable.apple);
    }

    public void redraw() {
        Canvas canvas = holder.lockCanvas(null);
        draw(canvas);
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event == null){
            return false;
        }
        Logger.log("Event: " + event.toString());


        switch (event.getAction()){
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
        for(int i = 0; i < recordedEvents.size(); i++){
            Logger.log("recorded events["+i+"]="+recordedEvents.get(i).getAction()+" "+recordedEvents.get(i).getX()+", "+recordedEvents.get(i).getY());
        }
        if(recordedEvents.size() == 2){
            selectedTileX = (int)((event.getX()-mapOffsetX)/grass.getWidth());
            selectedTileY = (int)((event.getY()-mapOffsetY)/grass.getHeight());
            gameController.onTileSelect(gameController.getMap()[selectedTileX][selectedTileY]);
            redraw();
        }
    }

    private void scrollMap(MotionEvent event) {
        if(event.getHistorySize() > 0){
            float endX = event.getX();
            float endY = event.getY();
            float startX = event.getHistoricalX(0);
            float startY = event.getHistoricalY(0);
            Canvas canvas = getHolder().lockCanvas(null);
            mapOffsetX += endX-startX;
            mapOffsetY += endY-startY;
            draw(canvas);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }


    @Override
    public void draw(Canvas canvas){
        drawMap(canvas);
        drawInfo(canvas);
        fixOffset(canvas);
    }

    public void drawInfo(Canvas canvas) {
        //apples
        canvas.translate(0,0);
        for(int i = 0; i < gameController.getApples(); i++){
            canvas.drawBitmap(apple, (float)4+i*apple.getWidth(), (float)4, null);
        }
        //gold
        for(int i = 0; i < gameController.getGold(); i++){
            canvas.drawBitmap(coin, (float)4+i*coin.getWidth(), (float)apple.getHeight()+8, null);
        }
    }

    private void fixOffset(Canvas canvas) {
        //TODO implement method
//        float maxOffsetY = canvas.getWidth() - getWidth();
//        float maxOffsetX = canvas.getHeight() - getHeight();
//        if(mapOffsetY < 0) maxOffsetY = 0;
//        if(mapOffsetY > maxOffsetY) mapOffsetY = maxOffsetY;
//        if(mapOffsetX < 0) mapOffsetX = 0;
//        if(mapOffsetX > maxOffsetX) mapOffsetX = maxOffsetX;
    }

    private void drawMap(Canvas canvas) {
        canvas.translate(mapOffsetX, mapOffsetY);
        canvas.drawColor(Color.BLACK);
        for(int posX = 0; posX < gameController.getMap().length; posX++){
            for(int posY = 0; posY < gameController.getMap()[posX].length; posY++){
                // draw tiles
                float x = posX * grass.getWidth();
                float y = posY * grass.getHeight();
                switch (gameController.getMap()[posX][posY].terrainType){
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
                if(gameController.getMap()[posX][posY].unit != null){
                    switch (gameController.getMap()[posX][posY].unit.getUnitType()){
                        case WORKER:
                            canvas.drawBitmap(worker, x, y, null);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if(selectedTileY != null && selectedTileX != null){
            float x = selectedTileX * grass.getWidth();
            float y = selectedTileY * grass.getHeight();
            canvas.drawBitmap(selection, x, y, null);
        }
    }

}
