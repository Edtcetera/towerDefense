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
            case tile231: //Grass finished
                tile = new Image ("/tiles/towerDefense_tile231.png");
                break;
            case tile093: //Dirt
                tile = new Image ("/tiles/towerDefense_tile093.png");
                break;
            case tile001: //Grass bottom
                tile = new Image ("/tiles/towerDefense_tile001.png");
                break;
            case tile047: //Grass top
                tile = new Image ("/tiles/towerDefense_tile047.png");
                break;
            case tile025: //Grass left
                tile = new Image ("/tiles/towerDefense_tile025.png");
                break;
            case tile023: //Grass right
                tile = new Image ("/tiles/towerDefense_tile023.png");
                break;
            case tile003: //Grass top left corner
                tile = new Image ("/tiles/towerDefense_tile003.png");
                break;
            case tile004: //Grass top right corner
                tile = new Image ("/tiles/towerDefense_tile004.png");
                break;
            case tile026: //Grass bottom left corner
                tile = new Image ("/tiles/towerDefense_tile026.png");
                break;
            case tile027: //Grass bottom right corner
                tile = new Image ("/tiles/towerDefense_tile027.png");
                break;
        }
        iv.setImage(tile);
        getChildren().add(iv);
    }
}
