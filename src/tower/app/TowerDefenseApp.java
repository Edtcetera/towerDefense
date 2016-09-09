package tower.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tile.Tile;
import tile.TileType;
import parser.LevelParser;

/**
 * Created by Edward on 8/26/2016.
 */
public class TowerDefenseApp extends Application {

    public static final int TILE_SIZE = 100;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private LevelParser levelParser;
    private Tile[][] board = new Tile[WIDTH][HEIGHT];
    private Group tileGroup = new Group();
    private Group spriteGroup = new Group(); //TODO:

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup);

        for (int y = 0; y < HEIGHT; y++){ //set everything as grass ground
            for (int x = 0; x < WIDTH; x++){
                Tile tile = new Tile(TileType.tile231, x, y);
                board[x][y] = tile;
                tileGroup.getChildren().add(tile);
            }
        }

        //TODO: change level editor, instead of coordinates use ASCII visual
        levelParser.readLevelFile("./assets/levels/level01.txt" , tileGroup, board);

        return root;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Tower Defense");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
