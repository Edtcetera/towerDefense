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


        //TODO: refactor this and make it better
        //Example timeline sequential animation
        final Timeline timeline1 = new Timeline();
        final Timeline timeline2 = new Timeline();
        final Timeline timeline3 = new Timeline();

        final KeyValue x1 = new KeyValue(super.getIv().xProperty(), 0*TILE_SIZE);
        final KeyValue y1 = new KeyValue(super.getIv().yProperty(), 7*TILE_SIZE);
        final KeyFrame kf1 = new KeyFrame(Duration.seconds(3), x1, y1);

        final KeyValue x2 = new KeyValue(super.getIv().xProperty(), 6*TILE_SIZE);
        final KeyFrame kf2 = new KeyFrame(Duration.seconds(2), x2);

        final KeyValue y3 = new KeyValue(super.getIv().yProperty(), 15*TILE_SIZE);
        final KeyFrame kf3 = new KeyFrame(Duration.seconds(3), y3);

        timeline1.getKeyFrames().add(kf1);
        timeline2.getKeyFrames().add(kf2);
        timeline3.getKeyFrames().add(kf3);
        SequentialTransition sequence = new SequentialTransition(timeline1, timeline2, timeline3);
        sequence.setCycleCount(5);
        sequence.play();
        //======================
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
