

/**
 * Rect.java
 * @version 2.2.0
 * @author Vlad Stejeroiu, ID: 984963
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Rect is an rectangular shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * rect's bounding rectangle
 */
public class Rect extends ClosedShape {
    //The width and height of the rect (major and minor axis)
    private int width, height;
    //The old width and old height of the rect
    private int Oldwidth, Oldheight;

    /**
     * Creates a rect.
     * @param shape The shape of the figure.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rect (in pixels).
     * @param height The height of the rect (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rect is filled with colour, false if opaque.
     * @param pulsing True if the rect is pulsing, false if not.
     */
    public Rect (String shape,int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled,boolean pulsing) {
        super (shape,insertionTime, x, y, vx, vy, colour, isFilled,pulsing);
        this.width = width;
        this.height = height;
        setOldParam();
    }

    /**
     * Method to convert a rect to a string.
     */
    public String toString () {
        String result = "This is a rect\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }
    /**
     * @return The shape of the rect
     */
    public String getShape(String shape) {
        return shape;
    }
    /**
     * @param width Resets the width.
     */
    public void setWidth (int width) {
        this.width = width;
    }
    /**
     * Resets the parameters of old height and old width 
     */
    public void setOldParam()
    {
    	this.Oldheight=height;
    	this.Oldwidth=width;
    }
    /**
     * @return The old height of the oval.
     */
    public int getOldHeight()
    {
    	return this.Oldheight;
    }
    /**
     * @return The old width of the oval.
     */
    public int getOldWidth()
    {
    	return this.Oldwidth;
    }
    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.height = height;
    }

    /**
     * @return The width of the rect.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return The height of the rect.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Draw the rect.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, width, height );
        }
        else {
            g.strokeRect( x, y, width, height );
        }
    }
}
