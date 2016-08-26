package tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
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
            case GRASS:
                tile = new Image ("/tiles/towerDefense_tile024.png");
                break;
            case DIRT:
                tile = new Image ("/tiles/towerDefense_tile093.png");
                break;
        }
        iv.setImage(tile);
        getChildren().add(iv);
    }
}
