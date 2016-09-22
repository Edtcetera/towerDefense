package sprite;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import tile.Node;

/**
 * Created by edwar on 9/21/2016.
 */
public abstract class Sprite extends StackPane {
    private double x;
    private double y;
    private Node[][] board;
    private ImageView iv;
    private Image image;

    public SpriteType getType() {
        return type;
    }

    public void setType(SpriteType type) {
        this.type = type;
    }

    private SpriteType type;

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        iv.setImage(image);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Node[][] getBoard() {
        return board;
    }

    public void setBoard(Node[][] board) {
        this.board = board;
    }

    public Sprite(double x, double y, Node[][] board, SpriteType type){
        this.x = x;
        this.y = y;
        this.board = board;
        this.type = type;
        iv = new ImageView();
        image = null;
    }

}
