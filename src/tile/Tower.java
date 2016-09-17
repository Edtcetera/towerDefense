package tile;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import tower.app.TowerDefenseApp;

import static tower.app.TowerDefenseApp.TILE_SIZE;

/**
 * Created by Edward on 8/26/2016.
 */
public class Tower extends Node {
    private int health;
    private ImageView tile;
    private Image sprite;
    private TowerType type;
    private Node[][] board;
    private Group tileGroup;
    private int locX;
    private int locY;

    private void setTowerType(TowerType type){
        switch(type){
            case tile249:
                sprite = new Image("/tiles/towerDefense_tile249.png");
                break;
            case tile250:
                sprite = new Image("/tiles/towerDefense_tile250.png");
                break;
            case tile180:
                sprite = new Image("/tiles/towerDefense_tile180.png");
        }
        tile.setImage(sprite);
        getChildren().add(tile);
    }

    private TowerType getTowerType(){
        return type;
    }



    private void addTower(Tower tile, Node[][] board){

    }

    /**
     * tower starts with 100 health, towertype, and at location x,y of game
     * board
     * @param type
     * @param x
     * @param y
     */
    public Tower(TowerType type, int x, int y){
        super();
        health = 100;
        locX = x;
        locY = y;
        this.type = type;
        setWidth(TILE_SIZE);
        setHeight(TILE_SIZE);

        relocate(x * TILE_SIZE, y * TILE_SIZE);

        tile = new ImageView();
        tile.setFitHeight(TILE_SIZE);
        tile.setPreserveRatio(true);
        setTowerType(type);

        hoverImage();
    }

    private void hoverImage(){
    }
}
