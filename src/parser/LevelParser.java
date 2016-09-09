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
    String filePath;
    Group tileGroup;
    Tile[][] board;

    public LevelParser(String filePath, Group tileGroup, Tile[][] board){
        this.filePath = filePath;
        this.tileGroup = tileGroup;
        this.board = board;
    }

    public void readLevelFile(){
        File file = new File(filePath);

        try{
            Scanner scanner = new Scanner(file);
            int levelY = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                handleLine(line, levelY, tileGroup, board);
                levelY++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private void handleLine(String line, int levelY, Group tileGroup, Tile[][] board) {
        String[] levelLine = line.split("\\|", 10);

        for (int levelX = 0; levelX < 10; levelX++) {
            String sTileType = levelLine[levelX];
            int tileType = Integer.parseInt(sTileType);

            Tile tile = null;
            switch (tileType) {
                case 25: //left grass
                    tile = new Tile(TileType.tile025, levelX, levelY);
                    break;
                case 26: //grass left bottom
                    tile = new Tile(TileType.tile026, levelX, levelY);
                    break;
                case 1: //grass bottom
                    tile = new Tile(TileType.tile001, levelX, levelY);
                    break;
                case 231: //grass
                    tile = new Tile(TileType.tile231, levelX, levelY);
                    break;
            }
            board[levelX][levelY] = tile;

            if (tile != null) {
                tileGroup.getChildren().add(tile);
            }
        }
    }
}
