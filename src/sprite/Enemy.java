package sprite;

import javafx.scene.Group;
import javafx.scene.image.Image;
import tile.Node;
import tile.Tile;

import java.util.ArrayList;
import java.util.Queue;
import static tower.app.TowerDefenseApp.TILE_SIZE;
import static tower.app.TowerDefenseApp.HEIGHT;
import static tower.app.TowerDefenseApp.WIDTH;

/**
 * Created by edwar on 9/21/2016.
 */
public class Enemy extends Sprite{
    private int health;
    private Queue<Tile> enemyTilePath;
    private String facing;
    private Double speed;

    public Enemy(double x, double y, Node[][] board, Group spriteGroup, Queue<Tile> enemyTilePath) {
        super(x, y, board, SpriteType.tile245);
        this.facing = null;
        this.speed = null;
        this.enemyTilePath = enemyTilePath;
        setEnemyImage(super.getType());
        setFacingDirection();
        health = 100;
        super.getIv().setFitHeight(TILE_SIZE);
        super.getIv().setPreserveRatio(true);
        super.getIv().relocate(x,y);
        spriteGroup.getChildren().add(super.getIv());
    }

    private boolean setFacingDirection() {
        Tile tile = enemyTilePath.peek();
        if (tile.getBoardY() == 0 &&
                tile.getBoardX() >= 0 && tile.getBoardX() <= WIDTH){
            //North side
            facing = "south";
            super.getIv().setRotate(90);
            return true;
        }
        else if (tile.getBoardY() == HEIGHT &&
                tile.getBoardX() >= 0 && tile.getBoardX() <= WIDTH){
            //South side
            facing = "north";
            super.getIv().setRotate(270);
            return true;
        }
        else if (tile.getBoardX() == 0 &&
                tile.getBoardY() > 0 && tile.getBoardY() < WIDTH){
            //West side
            facing = "east";
            super.getIv().setRotate(0);
            return true;
        }
        else if (tile.getBoardX() == WIDTH &&
                tile.getBoardY() > 0 && tile.getBoardY() < WIDTH){
            //East side
            facing = "west";
            super.getIv().setRotate(180);
            return true;
        }else{
            return false;
        }
    }

    private void setEnemyImage(SpriteType type){
        switch (type){

            case tile245:
                super.setImage(new Image("/tiles/towerDefense_tile245.png"));
                break;
        }
    }
}
