package tower.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pathfinding.Pathfinder;
import sprite.Enemy;
import tile.*;
import parser.LevelParser;

import java.util.Queue;

/**
 * Created by Edward on 8/26/2016.
 */
public class TowerDefenseApp extends Application {

    public static final int TILE_SIZE = 45;
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private LevelParser levelParser;
    private Pathfinder pathFinder;
    public static Tile[][] board = new Tile[WIDTH][HEIGHT];
    public static Group tileGroup = new Group();
    private static Group spriteGroup = new Group();
    private boolean gameStatus = true;

    public static Tile[][] getBoard(){
        return board;
    }

    private Parent createContent(){
        //TODO: scale to a level index file which points to different levels
        levelParser = new LevelParser("./assets/levels/level01.txt" , tileGroup, board);
        pathFinder = new Pathfinder();
        Pane root = new Pane();
        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup,spriteGroup);

        for (int y = 0; y < HEIGHT; y++){
            for (int x = 0; x < WIDTH; x++){
                Tile tile = new Tile(TileType.tile231, x, y);
                board[x][y] = tile;
                tileGroup.getChildren().add(tile);
            }
        }

        levelParser.readLevelFile();
        int startX = levelParser.getStartX();
        int startY = levelParser.getStartY();
        int goalX = levelParser.getGoalX();
        int goalY = levelParser.getGoalY();

        Queue<Tile> path = pathFinder.findPath(board[startX][startY],
                board[goalX][goalY],board);

        //Optional - displays path
        /*
        for (Tile i: path){
            i.setTile(new Image("/tiles/towerDefense_tile042.png"));
        }
        //------------------------
        */

        //TODO: create UI

        Enemy enemy = new Enemy(3*TILE_SIZE,0,board,spriteGroup);
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
