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
                Tile tile = new Tile(TileType.tile119, x, y);
                board[x][y] = tile;
                tileGroup.getChildren().add(tile);
            }
        }

        readLevelFile("./assets/levels/level01.txt" , tileGroup, board);



        /*
        //making dirt pathway TODO: cleanup, use scanner to read coord from txt file
        Tile dirtTile = new Tile(TileType.tile093, 2, 0);
        board[2][0] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 2, 1);
        board[2][1] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 2, 2);
        board[2][2] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 2, 3);
        board[2][3] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 2, 4);
        board[2][4] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 3, 4);
        board[3][4] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 4, 4);
        board[4][4] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 5, 4);
        board[5][4] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 6, 4);
        board[6][4] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 6, 5);
        board[6][5] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 6, 6);
        board[6][6] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 6, 7);
        board[6][7] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 6, 8);
        board[6][8] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        dirtTile = new Tile(TileType.tile093, 6, 9);
        board[6][9] = dirtTile;
        tileGroup.getChildren().add(dirtTile);
        Tile sideTileLeft = new Tile(TileType.tile092, 1,0);
        board[1][0] = sideTileLeft;
        tileGroup.getChildren().add(sideTileLeft);
        sideTileLeft = new Tile(TileType.tile092, 1,1);
        board[1][0] = sideTileLeft;
        tileGroup.getChildren().add(sideTileLeft);
        sideTileLeft = new Tile(TileType.tile092, 1,2);
        board[1][0] = sideTileLeft;
        tileGroup.getChildren().add(sideTileLeft);
        sideTileLeft = new Tile(TileType.tile092, 1,3);
        board[1][0] = sideTileLeft;
        tileGroup.getChildren().add(sideTileLeft);
        sideTileLeft = new Tile(TileType.tile092, 1,4);
        board[1][0] = sideTileLeft;
        tileGroup.getChildren().add(sideTileLeft);
        sideTileLeft = new Tile(TileType.tile092, 5,6);
        board[5][6] = sideTileLeft;
        tileGroup.getChildren().add(sideTileLeft);
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
            case 93:
                tile = new Tile(TileType.tile093, xTile, yTile);
                board[xTile][yTile] = tile;
                break;
        }

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
