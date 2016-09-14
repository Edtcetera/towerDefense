package tile;

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
    private int boardX;
    private int boardY;

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
    }

    private TowerType getTowerType(){
        return type;
    }



    private void addTower(ImageView tile){
        board[boardX][boardY] = tile;
        TowerDefenseApp.tileGroup.getChildren().add(tile);
    }

    /**
     * tower starts with 100 health, towertype, and at location x,y of game
     * board
     * @param type
     * @param x
     * @param y
     */
    public Tower(TowerType type, int x, int y){
        this.board = tower.app.TowerDefenseApp.board;
        tile = new ImageView();
        tile.setFitHeight(TILE_SIZE);
        tile.setPreserveRatio(true);
        boardX = x;
        boardY = y;
        health = 100;
        setTowerType(type);
        addTower(tile);
    }

    private void hoverImage(){
    }
}
