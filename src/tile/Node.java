package tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Created by edwar on 9/13/2016.
 */
//TODO: complete abstract class
public abstract class Node extends StackPane {
    private Node[][] board;
    private ImageView tile;
    private Image image;
    private int boardX;
    private int boardY;

    public Node(int x, int y){
        boardX = x;
        boardY = y;
    }

    private void hoverImage(){
    }

    public int getBoardX(){
        return boardX;
    }

    public void setBoardX(int x){
        boardX = x;
    }

    public int getBoardY(){
        return boardY;
    }

    public void setBoardY(int y){
        boardY = y;
    }

}
