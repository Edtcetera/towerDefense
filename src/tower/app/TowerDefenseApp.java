package tower.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tile.Tower;
import tile.TowerType;
import tile.Tile;
import tile.TileType;
import parser.LevelParser;

/**
 * Created by Edward on 8/26/2016.
 */
public class TowerDefenseApp extends Application {

    public static final int TILE_SIZE = 45;
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private LevelParser levelParser;
    private static Tile[][] board = new Tile[WIDTH][HEIGHT];
    private static Group tileGroup = new Group();
    private static Group spriteGroup = new Group();
    private boolean gameStatus = true;

    public static Tile[][] getBoard(){
        return board;
    }

    private Parent createContent(){
        //TODO: scale to a level index file which points to different levels
        levelParser = new LevelParser("./assets/levels/level01.txt" , tileGroup, board);
        Pane root = new Pane();
        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup);

        for (int y = 0; y < HEIGHT; y++){
            for (int x = 0; x < WIDTH; x++){
                Tile tile = new Tile(TileType.tile231, x, y);
                board[x][y] = tile;
                tileGroup.getChildren().add(tile);
            }
        }

        levelParser.readLevelFile();
        //TODO: create UI

        //board[1][1] = new Tower(TowerType.tile180, 1, 1);

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
