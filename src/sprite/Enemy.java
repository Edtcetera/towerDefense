package sprite;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.util.Duration;
import tile.Node;
import tile.Tile;

import java.util.ArrayList;
import java.util.List;
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
    private Group spriteGroup;

    public Enemy(double x, double y, Node[][] board, Group spriteGroup, Queue<Tile> enemyTilePath, Double speed) {
        super(x, y, board, SpriteType.tile245);
        facing = null;
        this.speed = speed;
        health = 100;
        this.spriteGroup = spriteGroup;
        this.enemyTilePath = enemyTilePath;
        setEnemyImage(super.getType());
        setFacingDirection();
        placeEnemy(x, y, spriteGroup);
        move(x, enemyTilePath);
    }


    private void destructEnemy() {
        System.out.println("Enemy destructed");
    }

    private void placeEnemy(double x, double y, Group spriteGroup) {
        super.getIv().setFitHeight(TILE_SIZE);
        super.getIv().setPreserveRatio(true);

        super.getIv().relocate(x*TILE_SIZE,y*TILE_SIZE);
        spriteGroup.getChildren().add(super.getIv());
    }

    private void move(double x, Queue<Tile> enemyTilePath) {
        SequentialTransition timeline = new SequentialTransition();

        while(enemyTilePath.isEmpty() == false){
            Tile pathTile = enemyTilePath.remove();
            KeyValue pathX = new KeyValue(super.getIv().translateXProperty(), (pathTile.getBoardX()-x)*TILE_SIZE);
            KeyValue pathY = new KeyValue(super.getIv().translateYProperty(), pathTile.getBoardY()*TILE_SIZE);
            KeyFrame pathKf = new KeyFrame(Duration.seconds(speed), pathX, pathY);
            Timeline tl = new Timeline(pathKf);
            timeline.getChildren().add(tl);
        }

        timeline.play();
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
                getChildren().add(super.getIv());
                break;
        }
    }
}
