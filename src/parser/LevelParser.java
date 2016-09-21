package parser;

import javafx.scene.Group;
import tile.Node;
import tile.Tile;
import tile.TileType;
import tower.app.TowerDefenseApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static tower.app.TowerDefenseApp.WIDTH;

/**
 * Created by edwar on 9/9/2016.
 */
public class LevelParser {
    String filePath;
    Group tileGroup;
    Node[][] board;
    int startX;
    int startY;
    int goalX;
    int goalY;

    public int getStartX(){
        return startX;
    }

    public int getStartY(){
        return startY;
    }

    public int getGoalX(){
        return goalX;
    }

    public int getGoalY(){
        return goalY;
    }

    public void setStartX(int x){
        startX = x;
    }
    public void setStartY(int y){
        startY = y;
    }
    public void setGoalX(int x){
        goalX = x;
    }
    public void setGoalY(int y){
        goalY = y;
    }

    public LevelParser(String filePath, Group tileGroup, Node[][] board){
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

    private void handleLine(String line, int levelY, Group tileGroup, Node[][] board) throws FileNotFoundException {
        String[] parseInfo = line.split(":",2);
        String[] levelLine = line.split("\\|", WIDTH);

        if (parseInfo[0].equals("start")){
            String[] startCoord = parseInfo[1].split(",",2);
            setStartX(Integer.parseInt(startCoord[0]));
            setStartY(Integer.parseInt(startCoord[1]));

        }

        else if (parseInfo[0].equals("goal")){
            String[] goalCoord = parseInfo[1].split(",",2);
            setGoalX(Integer.parseInt(goalCoord[0]));
            setGoalY(Integer.parseInt(goalCoord[1]));
        }

        else if(levelLine[0].equals("000") |
                levelLine[0].equals("025") |
                levelLine[0].equals("050") |
                levelLine[0].equals("026")) {
            for (int levelX = 0; levelX < WIDTH; levelX++) {
                String sTileType = levelLine[levelX];
                int tileType = Integer.parseInt(sTileType);

                Tile tile = null;
                switch (tileType) {
                    case 2: //grass bottom left corner
                        tile = new Tile(TileType.tile002, levelX, levelY);
                        break;
                    case 4: //grass top right corner
                        tile = new Tile(TileType.tile004, levelX, levelY);
                        break;
                    case 25: //left grass
                        tile = new Tile(TileType.tile025, levelX, levelY);
                        break;
                    case 23: //right grass
                        tile = new Tile(TileType.tile023, levelX, levelY);
                        break;
                    case 26: //grass left bottom
                        tile = new Tile(TileType.tile026, levelX, levelY);
                        break;
                    case 46: //grass top right corner
                        tile = new Tile(TileType.tile046, levelX, levelY);
                        break;
                    case 47: //grass top
                        tile = new Tile(TileType.tile047, levelX, levelY);
                        break;
                    case 1: //grass bottom
                        tile = new Tile(TileType.tile001, levelX, levelY);
                        break;
                    case 0: //nothing, use base
                        break;
                    case 135: //rock1
                        tile = new Tile(TileType.tile135, levelX, levelY);
                        break;
                    case 136: //rock2
                        tile = new Tile(TileType.tile136, levelX, levelY);
                        break;
                    case 137: //rock3
                        tile = new Tile(TileType.tile137, levelX, levelY);
                        break;
                    case 50: //dirt
                        tile = new Tile(TileType.tile050, levelX, levelY);
                        break;
                }
                board[levelX][levelY] = tile;

                if (tile != null) {
                    tileGroup.getChildren().add(tile);
                }
            }
        }
        else{
            throw new FileNotFoundException();
        }
    }
}
