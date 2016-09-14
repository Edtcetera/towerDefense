package tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import tower.app.TowerDefenseApp;

/**
 * Created by edwar on 9/13/2016.
 */
//TODO: complete abstract class
public abstract class Node extends StackPane {
    private Tile[][] board;
    private ImageView tile;
    private Image image;
    private int boardX;
    private int boardY;

    public ImageView getTile(){
        return tile;
    }

    public Image getImage(){
        return image;
    }

    public Node(int x, int y){
        boardX = x;
        boardY = y;
        board = TowerDefenseApp.getBoard();
    }
}
