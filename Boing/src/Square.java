


/**
 * Square.java
 * @version 2.2.0
 * @author Vlad Stejeroiu, ID: 984963
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the square's bounding rectangle.
 */

public class Square extends ClosedShape {
    //The side of the square
    private int side;
    //The old side of the square
    private int OldSide;


    /**
     * Creates a square.
     * @param shape The shape of the figure.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     * @param pulsing True if the square is pulsing, false if not.
     */
    public Square (String shape,int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled,boolean pulsing) {
        super (shape,insertionTime, x, y, vx, vy, colour, isFilled,pulsing);
        this.side = side;
        setOldSide(OldSide);
    }

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }
    /**
     * @return The shape of the square
     */
    public String getShape(String shape) {
        return shape;
    }
    /**
     * @param side the side of the square.
     */
    public void setOldSide(int OldSide){
        this.OldSide=side;
    }
    /**
     * @return The old side of the square.
     */
    public int getOldSide(){
        return this.OldSide;
    }
    /**
     * @param side the diameter.
     */
    public void setSide (int side) {
        this.side = side;
    }

    /**
     * @return The side of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */

    /**
     * @return The width of the square.
     */
    public int getWidth() {
        return side;
    }

    /**
     * @return The height of the square.
     */
    public int getHeight() {
        return side;
    }

    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side );
        }
        else {
            g.strokeRect( x, y, side, side );
        }
    }
}
