package tile;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import tile.Tile;
import tile.TowerType;

/**
 * Created by Edward on 8/26/2016.
 */
public class Tower extends Tile {
    private int health;
    private ImageView tile;
    private Image sprite;
    private Tile[][] board;
    private Group spriteGroup;
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

    private void addTower(ImageView tile){
        getChildren().add(tile);
    }

    /**
     * tower starts with 100 health, towertype, and at location x,y of game
     * board
     * @param type
     * @param x
     * @param y
     */
    public Tower(TowerType type, int x, int y){
        super(TileType.tile001, 1, 1); //TODO:
        health = 100;
        setTowerType(type);
        addTower(tile);
    }
}
