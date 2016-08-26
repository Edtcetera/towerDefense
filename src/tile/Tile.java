package tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import sprite.Sprite;

import static tower.app.TowerDefenseApp.TILE_SIZE;

/**
 * Created by Edward on 8/26/2016.
 */
public class Tile extends StackPane {
    private Sprite sprite;
    private ImageView tile;

    public boolean hasSprite(){
        return sprite != null;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    public boolean hasTile(){
        return tile != null;
    }

    public ImageView getTile(){
        return tile;
    }

    public void setTile(Image image){
        tile.setImage(image);
    }

    public Tile(TileType type, int x, int y){
        setWidth(TILE_SIZE);
        setHeight(TILE_SIZE);

        relocate(x * TILE_SIZE, y * TILE_SIZE);

        ImageView iv = new ImageView();
        iv.setFitHeight(TILE_SIZE);
        iv.setPreserveRatio(true);
        Image tile = null;

        switch (type){
            case tile119: //Grass
                tile = new Image ("/tiles/towerDefense_tile119.png");
                break;
            case tile093: //Dirt
                tile = new Image ("/tiles/towerDefense_tile093.png");
                break;
            case tile116: //Grass bottom
                tile = new Image ("/tiles/towerDefense_tile116.png");
                break;
            case tile070: //Grass top
                tile = new Image ("/tiles/towerDefense_tile070.png");
                break;
            case tile092: //Grass left
                tile = new Image ("/tiles/towerDefense_tile092.png");
                break;
            case tile094: //Grass right
                tile = new Image ("/tiles/towerDefense_tile094.png");
                break;
            case tile069: //Grass top left corner
                tile = new Image ("/tiles/towerDefense_tile069.png");
                break;
            case tile071: //Grass top right corner
                tile = new Image ("/tiles/towerDefense_tile071.png");
                break;
            case tile115: //Grass bottom left corner
                tile = new Image ("/tiles/towerDefense_tile115.png");
                break;
            case tile117: //Grass bottom right corner
                tile = new Image ("/tiles/towerDefense_tile117.png");
                break;
        }
        iv.setImage(tile);
        getChildren().add(iv);
    }
}
