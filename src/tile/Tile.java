package tile;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import static tower.app.TowerDefenseApp.TILE_SIZE;

/**
 * Created by Edward on 8/26/2016.
 */
public class Tile extends Node {
    private Tower tower;
    private ImageView tile;
    private Image image;
    private TileType type;
    private int locX;
    private int locY;

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


    public ImageView getTile() {
        return tile;
    }

    public void setTile(Image image) {
        tile.setImage(image);
    }


    public Tile(TileType type, int x, int y) {
        super();
        locX = x;
        locY = y;
        this.type = type;
        setWidth(TILE_SIZE);
        setHeight(TILE_SIZE);

        relocate(x * TILE_SIZE, y * TILE_SIZE);

        tile = new ImageView();
        tile.setFitHeight(TILE_SIZE);
        tile.setPreserveRatio(true);
        setTileType(type);

        hoverImage();
        towerMouseListener();
    }

    /**
     * abstract class hoverImage method
     */
    private void hoverImage() {
        /**
         * hover image on valid (grass) tile for construction or action. Tiles not valid
         * for construction is dirt, side path, tiles with rocks, trees etc.
         * When mouse exits tile, revert back to grass tile
         */
        setOnMouseEntered(e -> {
            if (isGrass()){
                setTile(new Image("/tiles/towerDefense_tile042.png"));
                setOnMouseExited(f -> {
                    setTile(new Image("/tiles/towerDefense_tile231.png"));
                });
            }
        });
    }

    private void towerMouseListener(){
        setOnMouseClicked(e -> {
            if (isGrass()){
                Tower foundation = new Tower(TowerType.tile180, locX, locY);
            }
        });
    }

    private boolean isGrass(){
        if (getType() == TileType.tile231){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Sets image assets as Image
     * @param type
     */
    private void setTileType(TileType type){

        switch (type) {
            case tile231: //Grass finished
                image = new Image("/tiles/towerDefense_tile231.png");
                break;
            case tile093: //Dirt
                image = new Image("/tiles/towerDefense_tile093.png");
                break;
            case tile001: //Grass bottom
                image = new Image("/tiles/towerDefense_tile001.png");
                break;
            case tile002: //grass bottom left corner
                image = new Image("/tiles/towerDefense_tile002.png");
                break;
            case tile046: //Grass top right corner
                image = new Image("/tiles/towerDefense_tile046.png");
                break;
            case tile047: //Grass top
                image = new Image("/tiles/towerDefense_tile047.png");
                break;
            case tile025: //Grass left
                image = new Image("/tiles/towerDefense_tile025.png");
                break;
            case tile023: //Grass right
                image = new Image("/tiles/towerDefense_tile023.png");
                break;
            case tile003: //Grass top left corner
                image = new Image("/tiles/towerDefense_tile003.png");
                break;
            case tile004: //Grass top right corner
                image = new Image("/tiles/towerDefense_tile004.png");
                break;
            case tile026: //Grass bottom left corner
                image = new Image("/tiles/towerDefense_tile026.png");
                break;
            case tile027: //Grass bottom right corner
                image = new Image("/tiles/towerDefense_tile027.png");
                break;
            case tile135: //rock1
                image = new Image("/tiles/towerDefense_tile135.png");
                break;
            case tile136: //rock2
                image = new Image("/tiles/towerDefense_tile136.png");
                break;
            case tile137: //rock3
                image = new Image("/tiles/towerDefense_tile137.png");
                break;
            case tile050: //dirt
                image = new Image("/tiles/towerDefense_tile050.png");
                break;
            case tile042: //hover grass image
                image = new Image("/tiles/towerDefense_tile042.png");
                break;
        }
        tile.setImage(image);
        getChildren().add(tile);
    }
}
