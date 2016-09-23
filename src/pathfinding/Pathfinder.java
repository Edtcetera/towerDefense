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
    int oldX;
    int oldY;
    int startX;
    int startY;
    int goalX;
    int goalY;

    public Queue<Tile> findPath(Tile start, Tile goal, Tile[][] board) {
        startX = start.getBoardX(); //3
        startY = start.getBoardY(); //0
        goalX = goal.getBoardX();   //9
        goalY = goal.getBoardY();   //14

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
        return closedSet;
    }


}
