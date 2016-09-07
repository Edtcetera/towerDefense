package sprite;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

/**
 * Created by Edward on 8/26/2016.
 */
public class Sprite extends StackPane {
    private int health;
    private ImageView tile;

    public Sprite(SpriteType type, int x, int y){
        //TODO:
        ImageView iv = new ImageView();
        Image sprite = null;

        switch(type){
            case tile245:
                sprite = new Image("/tiles/towerDefense_tile245.png");
                break;
            case tile246:
                sprite = new Image("/tiles/towerDefense_tile246.png");
                break;
            case tile247:
                sprite = new Image("/tiles/towerDefense_tile247.png");
                break;
            case tile248:
                sprite = new Image("/tiles/towerDefense_tile248.png");
                break;
            case tile249:
                sprite = new Image("/tiles/towerDefense_tile249.png");
                break;
            case tile250:
                sprite = new Image("/tiles/towerDefense_tile250.png");
                break;
        }
        iv.setImage(sprite);
        getChildren().add(iv);
    }
}
