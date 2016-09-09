package tower.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tile.Tile;
import tile.TileType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Edward on 8/26/2016.
 */
public class TowerDefenseApp extends Application {

    public static final int TILE_SIZE = 100;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
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
        readLevelFile("./assets/levels/level01.txt" , tileGroup, board);



        /*
        //making dirt pathway TODO: cleanup, use scanner to read coord from txt file
        Tile dirtTile = new Tile(TileType.tile093, 2, 0);
        board[2][0] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        */

        return root;
    }

    public void readLevelFile(String filePath, Group tileGroup, Tile[][] board){
        File file = new File(filePath);

        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                handleLevelFile(line, tileGroup, board);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private void handleLevelFile(String line, Group tileGroup, Tile[][] board) {
        String[] component = line.split(":");

        String sTileType = component[0];
        int tileType = Integer.parseInt(sTileType);

        String sXTile = component[1];
        int xTile = Integer.parseInt(sXTile);

        String sYTile = component[2];
        int yTile = Integer.parseInt(sYTile);

        Tile tile = null;
        switch(tileType){
            case 25: //left grass
                tile = new Tile(TileType.tile025, xTile, yTile);
                //board[xTile][yTile] = tile;
                break;
            case 26: //grass left bottom
                tile = new Tile(TileType.tile026, xTile, yTile);
                //board[xTile][yTile] = tile;
                break;
            case 1: //grass bottom
                tile = new Tile(TileType.tile001, xTile, yTile);
                //board[xTile][yTile] = tile;
                break;
        }
        board[xTile][yTile] = tile;

        if (tile != null){
            tileGroup.getChildren().add(tile);
        }
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
