

/**
 * ClosedShape.java

 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * A ClosedShape is any shape that can be drawn without
 * taking a pencil off a piece of paper.
 * It's representation on computer has a line colour
 * and a position on the drawable screen component.
 * It can be filled in with colour or opaque.
 * This class is a super class for all shapes.
 */

public class ClosedShape {
	/**
     *  The type of the Shape.
     */
    protected String shape;
    /**
     *  The x position of the Shape.
     */
    protected int x;
    /**
     * The y position of the Shape.
     */
    protected int y;

    /**
     *  The x position of the Shape.
     */
    protected int xVec;

    /**
     * The y position of the Shape.
     */
    protected int yVec;

    /**
     * The line colour of the shape, or the filled in
     * colour if the Shape has fill.
     */
    protected Color colour;

    /**
     * Determines if the Shape has a fill colour or not.
     */
    protected boolean isFilled;

    /**
     * Encodes the insertion time into the scene
     */
    protected boolean check= true ;
    private int insertionTime;
    private boolean pulsing;
    /**
     * Creates a closed shape object.
     * @param shape The shape of the figure.
     * @param x The x position.
     * @param y the y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param colour The line or fill colour.
     * @param isFilled True if the shape is filled, false if not.
     * @param pulsing True if the circle is pulsing, false if not.
     */
    protected ClosedShape (String shape,int insertionTime, int x, int y, int vx, int vy, Color colour, boolean isFilled,boolean pulsing) {
    	this.shape=shape;
        this.x = x;
        this.y = y;
        this.xVec = vx;
        this.yVec = vy;
        this.colour = colour;
        this.pulsing = pulsing;
        this.isFilled = isFilled;
        this.insertionTime = insertionTime;
    }

    /**
     * The method returns a string suitable for printing.
     * @return string to print out shape.
     */
    public String toString () {
        String result = "";
        result += "Its position is " + x + " " + y + "\n";
        result += "Its velocity is " + xVec + " " + yVec + "\n";
        result += "Its colour is " + colour + "\n";
        if (isFilled)
            result += "It is filled" + "\n";
        else
            result += "It is not filled" + "\n";
        result += "It should be inserted at " + insertionTime + "\n";
        return result;
    }
    /**
     * Resets the shape type.
     */
    public void setShape(String shape)
    {
    	this.shape=shape;
    }
    /**
     * @return The shape variable.
     */
    public String getShape()
    {
    	return this.shape;
    }
    /**
     * Resets the x position.
     */
    public void setX (int x) {
        this.x = x;
    }

    /**
     * Resets the y position.
     */
    public void setY (int y) {
        this.y = y;
    }

    /**
     * Resets the x vector
     */
    public void setVecX (int x) {
        this.xVec = x;
    }//end setVecX

    /**
     * Resets the y position.
     */
    public void setVecY (int y) {
        this.yVec = y;
    }//end setVecY

    /**
     * Resets the colour.
     */
    public void setColour (Color colour) {
        this.colour = colour;
    }

    /**
     * Sets the shape to filled.
     */
    public void setFilled () {
        isFilled = true;
    }

    /**
     * Sets the shape to unfilled.
     */
    public void unsetFilled () {
        isFilled = false;
    }

    /**
     * Sets the insertion time.
     */
    public void setInsertionTime (int time) {
        insertionTime = time;
    }
    /**
     * @return True if the shape is pulsing, false if it is not.
     */
    public boolean isPulsing()
    {
    	return pulsing;
    }
    
    /**
     * @return The x position value.
     */
    public int getX() {
        return x;
    }

    /**
     * @return The y position value.
     */
    public int getY() {
        return y;
    }

    /**
     * @return The colour.
     */
    public Color getColour() {
        return colour;
    }

    /**
     * @return True if the shape is filled, false if not.
     */
    public boolean isFilled() {
        return isFilled;
    }

    /**
     * @return the insertion time.
     */
    public int getInsertionTime () {
        return insertionTime;
    }
    /**
     * Sets the moving action
     * @param check Checks the current pulsing movement action
     */
    public void setMoving(boolean check){
        this.check=check;
    }

    /**
     * Returns the current moving action
     */
    public boolean getMoving(){
        return this.check;
    }
    /**
     * Puts the shape back in bounds in X
     */
    public void putInBoundsX (double winX) {
        if (x < 0) x = 0;
        if (x + this.getWidth() > winX) {
            x = (int) (winX - Math.ceil (this.getWidth ()));
        }
    }//end inBoundsX;

    /**
     * Puts the shape back in bounds
     */
    public void putInBoundsY (double winY) {
        if (y < 0) y = 0;
        if (y + this.getHeight() > winY) {
            y = (int) (winY - Math.ceil (this.getHeight ()));
        }
    }//end inBoundsY;

    /**
     * Bounces the shape off a vertical wall
     */
    public void bounceX () {
        xVec = -xVec;
    }

    /**
     * Bounces the shape off a horizontal wall
     */
    public void bounceY () {
        yVec = -yVec;
    }

    /**
     * Returns true if the shapes have gone out of bounds in X
     */
    public boolean outOfBoundsX (double winX) {
        return (x + this.getWidth()> winX) || (x < 0);
    }

    /**
     * Returns true if the shapes have gone out of bounds in Y
     */
    public boolean outOfBoundsY (double winY) {
        return (y + this.getHeight() > winY) || (y < 0);
    }

    /**
     * Takes in a direction and a velocity and moves the shape
     * in that direction on unit
     */
    public void move () {
        x += xVec;
        y += yVec;
    }
    
    /**
     * Draws the object to the current component.
     * @param g The graphics object associated with the drawing component.
     */
    public void draw (GraphicsContext g) {
        System.out.println ("You forgot to override this method! (draw)");
        System.out.println ("Don't modify this method.");
    }

    /**
     * Get the width of the current component
     */
    public int getWidth () {
        System.out.println ("You forgot to override this method! (getWidth)");
        System.out.println ("Don't modify this method.");
        return 1;
    }

    /**
     * Get the width of the current component
     */
    public int getHeight () {
        System.out.println ("You forgot to override a method! (getHeight)");
        System.out.println ("Don't modify this method.");
        return 1;
    }
}
