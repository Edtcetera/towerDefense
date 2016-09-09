package parser;

import javafx.scene.Group;
import tile.Tile;
import tile.TileType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by edwar on 9/9/2016.
 */
public class LevelParser {
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
}
