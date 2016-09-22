package sprite;

import javafx.scene.Group;
import javafx.scene.image.Image;
import tile.Node;

/**
 * Created by edwar on 9/21/2016.
 */
public class Enemy extends Sprite{
    private int health;

    public Enemy(double x, double y, Node[][] board, Group spriteGroup) {
        super(x, y, board, SpriteType.tile245);
        setEnemyImage(super.getType());
        health = 100;
        super.getIv().setFitHeight(45);
        super.getIv().setPreserveRatio(true);
        super.getIv().relocate(x,y);
        spriteGroup.getChildren().add(super.getIv());
    }

    private void setEnemyImage(SpriteType type){
        switch (type){

            case tile245:
                super.setImage(new Image("/tiles/towerDefense_tile245.png"));
                break;
        }
    }
}
