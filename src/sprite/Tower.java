package sprite;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

/**
 * Created by Edward on 8/26/2016.
 */
public class Tower extends StackPane {
    private int health;
    private ImageView tile;

    public Tower(TowerType type, int x, int y){
        //TODO:
        ImageView iv = new ImageView();
        Image sprite = null;

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
        iv.setImage(sprite);
        getChildren().add(iv);
    }
}
