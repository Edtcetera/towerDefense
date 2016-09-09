package tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import sprite.Tower;

import static tower.app.TowerDefenseApp.TILE_SIZE;

/**
 * Created by Edward on 8/26/2016.
 */
public class Tile extends StackPane {
    private Tower tower;
    private ImageView tile;
    private TileType type;

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public boolean hasTower() {
        return tower != null;
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public boolean hasTile() {
        return tile != null;
    }

    public ImageView getTile() {
        return tile;
    }

    public void setTile(Image image) {
        tile.setImage(image);
    }

    public Tile(TileType type, int x, int y) {
        this.type = type;
        setWidth(TILE_SIZE);
        setHeight(TILE_SIZE);

        relocate(x * TILE_SIZE, y * TILE_SIZE);

        tile = new ImageView();
        tile.setFitHeight(TILE_SIZE);
        tile.setPreserveRatio(true);
        Image tileImage = null;

        switch (type) {
            case tile231: //Grass finished
                tileImage = new Image("/tiles/towerDefense_tile231.png");
                break;
            case tile093: //Dirt
                tileImage = new Image("/tiles/towerDefense_tile093.png");
                break;
            case tile001: //Grass bottom
                tileImage = new Image("/tiles/towerDefense_tile001.png");
                break;
            case tile002: //grass bottom left corner
                tileImage = new Image("/tiles/towerDefense_tile002.png");
                break;
            case tile046: //Grass top right corner
                tileImage = new Image("/tiles/towerDefense_tile046.png");
                break;
            case tile047: //Grass top
                tileImage = new Image("/tiles/towerDefense_tile047.png");
                break;
            case tile025: //Grass left
                tileImage = new Image("/tiles/towerDefense_tile025.png");
                break;
            case tile023: //Grass right
                tileImage = new Image("/tiles/towerDefense_tile023.png");
                break;
            case tile003: //Grass top left corner
                tileImage = new Image("/tiles/towerDefense_tile003.png");
                break;
            case tile004: //Grass top right corner
                tileImage = new Image("/tiles/towerDefense_tile004.png");
                break;
            case tile026: //Grass bottom left corner
                tileImage = new Image("/tiles/towerDefense_tile026.png");
                break;
            case tile027: //Grass bottom right corner
                tileImage = new Image("/tiles/towerDefense_tile027.png");
                break;
            case tile135: //rock1
                tileImage = new Image("/tiles/towerDefense_tile135.png");
                break;
            case tile136: //rock2
                tileImage = new Image("/tiles/towerDefense_tile136.png");
                break;
            case tile137: //rock3
                tileImage = new Image("/tiles/towerDefense_tile137.png");
                break;
        }
        tile.setImage(tileImage);
        getChildren().add(tile);
        setOnMouseEntered(e -> {
            System.out.println("mouse entered");
            if (type == TileType.tile231){
                System.out.println("grass type");
            }
        });
    }
}
