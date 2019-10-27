
/**
 * Hexagon.java
 * @version 2.10.0
 * @author Vlad Stejeroiu, ID: 984963
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import java.lang.Math.*;

/**
 * Hexagon is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left point of
 * the hexagon's bounding rectangle.
 */

public class Hexagon extends ClosedShape{
	//retains the coordinates of the hexagon's edges 
    private double[] xAxis = new double[6];
    private double[] yAxis = new double[6];
    //the side of the hexagon
    private int side;
    //the old side of the hexagon
    private int OldSide;
    
    /**
     * Creates a hexagon.
     * @param shape The shape of the figure.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the hexagon.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the hexagon is filled, false if not.
     * @param pulsing True if the hexagon is pulsing, false if not.
     */
    public Hexagon(String shape,int insertionTime, int x, int y, int vx, int vy, int side, Color color, boolean isFilled,boolean pulsing){
        super(shape,insertionTime, x, y, vx, vy, color, isFilled,pulsing);
        setSide(side);
        setOldSide(OldSide);
        setCoordinates(x,y,side);
    }
    /**
     * Sets the coordinates for the hexagon's 6 edges.
     * @param x1 The display component's x position.
     * @param y1 The display component's y position.
     * @param side The side of the hexagon.
     */
    public void setCoordinates(double x1, double y1,int side){
    	setSide(side);
    	//height of the hexagon
    	double h=(side*Math.sqrt(3))/4;
    	//set the starting point
        this.xAxis[0] = x1;
        this.yAxis[0] = y1;
        //set the second point using the first one 
        this.xAxis[1] = this.xAxis[0] + side;
        this.yAxis[1] = this.yAxis[0];
      //set the third point using the first one 
        this.xAxis[2] = this.xAxis[0] + (3*side)/2 ;
        this.yAxis[2] = this.yAxis[0] + h;
        
      //set the fourth point using the first one 
        this.xAxis[3] = this.xAxis[0] + side;
        this.yAxis[3] = this.yAxis[0] + 2*h;
      //set the fifth point using the first one 
        this.xAxis[4] = this.xAxis[0];
        this.yAxis[4] = this.yAxis[0] + 2*h;
      //set the sixth point using the first one 
        this.xAxis[5] = this.xAxis[0] -side/2;
        this.yAxis[5] = this.yAxis[0] +h;
    }
    /**
     * Method to convert a hexagon to a string.
     */
    public String toString () {
        String result = "This is a hexagon\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }
   
    /**
     * @return The shape of the circle
     */
    public String getShape(String shape) {
        return shape;
    }
    /**
     * @param OldDiameter the old diameter.
     */
    public void setOldSide(int OldSide){
        this.OldSide=side;
    }
    /**
     * @return The old side of the hexagon
     */
    public int getOldSide(){
        return this.OldSide;
    }
    /**
     * @param side The side of the hexagon.
     */
    public void setSide(int side){
        this.side=side;
    }
    /**
     * @return The side of the hexagon
     */
    public int getSide(){
        return this.side;
    }
    /**
     * @return The height of the hexagon.
     */
    @Override
    public int getHeight() {
        return side;
    }
    /**
     * @return The width of the hexagon.
     */
    @Override
    public int getWidth() {
        return side;
    }
    /**
     * Returns true if the hexagon has gone out of bounds in X.
     */
    @Override
    public boolean outOfBoundsX(double winX){
        return (this.xAxis[2] > winX) ||  (this.xAxis[5] < 0) ;
    }
    /**
     * Returns true if the hexagon has gone out of bounds in Y.
     */
    @Override
    public boolean outOfBoundsY(double winY){
        return  (this.yAxis[0] < 0)  || (this.yAxis[1] < 0) || (this.yAxis[3] > winY) || (this.yAxis[4] > winY);
    }
    /**
     * Puts the hexagon back in bounds in X.
     */
    @Override
    public void putInBoundsX (double winX) {
    	double h=(side*Math.sqrt(3))/4;
    	//case of left edge going out of bounds
        if (this.xAxis[5] < 0){
            this.xAxis[5] = 0;
        }
        //case of right edge going out of bounds
        if (this.xAxis[2] > winX ) {
            this.xAxis[2] = winX ;
            setCoordinates(this.xAxis[0], this.yAxis[0],side);
        }
        //special case of left point getting too small
        if (this.xAxis[5] < this.xAxis[0] -h) {
            this.xAxis[5] = (int)(winX-Math.ceil(this.side));
            setCoordinates(this.xAxis[0], this.yAxis[0],side);
        }
    }

    /**
     * Puts the hexagon back in bounds in Y.
     */
    @Override
    public void putInBoundsY (double winY) {
    	//case of upper edge going out of bounds
        if (this.yAxis[1] > winY) {
            this.yAxis[1] = (int)(winY-Math.ceil(this.side));
            setCoordinates(this.yAxis[0], this.yAxis[0],side);
        }
      //case of upper edge going out of bounds
        if (this.yAxis[0] > winY) {
            this.yAxis[0] = (int)(winY-Math.ceil(this.side));
            setCoordinates(this.yAxis[0], this.yAxis[0],side);
        }
      //case of lower edge going out of bounds
        if (this.yAxis[3] < 0) {
            this.yAxis[3] = 0;    
        }
      //case of lower edge going out of bounds
        if (this.yAxis[4] < 0) {
            this.yAxis[4] = 0;

        }
    }

    /**
     * Takes in a direction and a velocity and moves the hexagon
     * in that direction on unit
     */
    @Override
    public void move() {
        for(int i = 0; i < 6; i++){
            this.xAxis[i] += xVec;
            this.yAxis[i] += yVec;
        }
    }
    /**
     * Draw the hexagon on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillPolygon(xAxis, yAxis, 6);
        }
        else {
            g.strokePolygon(xAxis, yAxis, 6);
        }
    }
}