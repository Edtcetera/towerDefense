package pathfinding;

import javafx.scene.Group;
import tile.Node;
import tile.Tile;
import tile.TileType;

import java.util.*;

/**
 * Created by edwar on 9/21/2016.
 */
public class Pathfinder {

    public boolean findPath(Tile start, Tile goal, Tile[][] board) {
        //start = 3,0
        //goal = 9,14
        int oldX = 100;
        int oldY = 100;
        int startX = start.getBoardX(); //3
        int startY = start.getBoardY(); //0
        int goalX = goal.getBoardX();   //9
        int goalY = goal.getBoardY();   //14

        Queue<Tile> closedSet = new LinkedList<>();
        Queue<Tile> openSet = new LinkedList<>();
        closedSet.add(start);

        while (startX != goal.getBoardX() | startY != goal.getBoardY()) {
            Tile southTile;
            Tile northTile;
            Tile eastTile;
            Tile westTile;

            try{
                southTile = board[startX][startY + 1];
                openSet.add(southTile);
            }
            catch(ArrayIndexOutOfBoundsException e){
                southTile = null;
            }
            try{
                northTile = board[startX][startY - 1];
                openSet.add(northTile);
            }
            catch(ArrayIndexOutOfBoundsException e){
                northTile = null;
            }
            try{
                eastTile = board[startX + 1][startY];
                openSet.add(eastTile);
            }
            catch(ArrayIndexOutOfBoundsException e){
                eastTile = null;
            }
            try{
                westTile = board[startX - 1][startY];
                openSet.add(westTile);
            }
            catch(ArrayIndexOutOfBoundsException e){
                westTile = null;
            }

            for (Tile i : openSet) {
                if (i != null && i.getType() == TileType.tile050 &&
                        i.getBoardX() != oldX | i.getBoardY() != oldY) {
                    closedSet.add(i);
                    oldX = startX;
                    oldY = startY;
                    startX = i.getBoardX();
                    startY = i.getBoardY();
                    openSet.clear();
                    break;
                }
            }
        }
        for (Tile i : closedSet){
            System.out.println(i.getBoardX() + "," + i.getBoardY());
        }
        return true;
    }


}