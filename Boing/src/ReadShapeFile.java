
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadShapeFile {

    // TODO: You will likely need to write four methods here. One method to
    // construct each shape
    // given the Scanner passed as a parameter. I would suggest static
    // methods in this case.

    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in
     *            the scanner of the file
     * @return the queue represented by the data file
     */
	
	/**
	 * Reads the data of a rect and returns the object
	 * @param in The scanner is reading the data from the file
	 * @return the rect created from the data file
	 */

    private static Rect RectInput(Scanner in){
        int x=in.nextInt();
        int y=in.nextInt();
        int vx=in.nextInt();
        int vy=in.nextInt();
        boolean isFilled=in.nextBoolean();
        int width=in.nextInt();
        int height=in.nextInt();
        int R=in.nextInt();
        int G=in.nextInt();
        int B=in.nextInt();
        boolean pulsing=in.nextBoolean();
        int insertionTime=in.nextInt();
        Color colour=Color.rgb(R,G,B);

        Rect rect=new Rect("rect",insertionTime, x,y,vx, vy, width, height,colour,isFilled,pulsing);

        return rect;
    }
    /**
	 * Reads the data of a square and returns the object
	 * @param in The scanner is reading the data from the file
	 * @return the square created from the data file
	 */
    private static Square SquareInput(Scanner in){
        int x=in.nextInt();
        int y=in.nextInt();
        int vx=in.nextInt();
        int vy=in.nextInt();
        boolean isFilled=in.nextBoolean();
        int side=in.nextInt();
        int R=in.nextInt();
        int G=in.nextInt();
        int B=in.nextInt();
        boolean pulsing=in.nextBoolean();
        int insertionTime=in.nextInt();
        Color colour= Color.rgb(R,G,B);

        Square square=new Square("square",insertionTime, x, y, vx, vy, side, colour, isFilled,pulsing);

        return square;
    }
    /**
	 * Reads the data of a hexagon and returns the object
	 * @param in The scanner is reading the data from the file
	 * @return the hexagon created from the data file
	 */
    private static Hexagon HexagonInput(Scanner in){
        int x=in.nextInt();
        int y=in.nextInt();
        int vx=in.nextInt();
        int vy=in.nextInt();
        boolean isFilled=in.nextBoolean();
        int side=in.nextInt();
        int R=in.nextInt();
        int G=in.nextInt();
        int B=in.nextInt();
        boolean pulsing=in.nextBoolean();
        int insertionTime=in.nextInt();
        Color colour= Color.rgb(R,G,B);

        Hexagon hexagon=new Hexagon("hexagon",insertionTime, x, y, vx, vy, side, colour, isFilled,pulsing);

        return hexagon;
    }
    /**
	 * Reads the data of a circle and returns the object
	 * @param in The scanner is reading the data from the file
	 * @return the circle created from the data file
	 */
    private static Circle CircleInput(Scanner in) {
        int x=in.nextInt();
        int y=in.nextInt();
        int vx=in.nextInt();
        int vy=in.nextInt();
        boolean isFilled=in.nextBoolean();
        int diameter=in.nextInt();
        int R=in.nextInt();
        int G=in.nextInt();
        int B=in.nextInt();
        boolean pulsing=in.nextBoolean();
        int insertionTime=in.nextInt();
        Color colour= Color.rgb(R,G,B);

        Circle circle=new Circle("circle",insertionTime, x, y, vx, vy, diameter, colour, isFilled,pulsing);

        return circle;
        
    }
    /**
	 * Reads the data of an oval and returns the object
	 * @param in The scanner is reading the data from the file
	 * @return the oval created from the data file
	 */
    private static Oval OvalInput(Scanner in) {
        int x=in.nextInt();
        int y=in.nextInt();
        int vx=in.nextInt();
        int vy=in.nextInt();
        boolean isFilled=in.nextBoolean();
        int width=in.nextInt();
        int height=in.nextInt();
        int R=in.nextInt();
        int G=in.nextInt();
        int B=in.nextInt();
        boolean pulsing=in.nextBoolean();
        int insertionTime=in.nextInt();
        Color colour=Color.rgb(R,G,B);

        Oval oval=new Oval("oval",insertionTime, x,y,vx, vy, width, height,colour,isFilled,pulsing);

        return oval;
    }
    /**
	 * Reads the data of the file, sees which shape to add to the queue and returns the constructed queue
	 * @param in The scanner is reading the data from the file
	 * @return the queue represented by the data file
	 */
    private static Queue<ClosedShape> readDataFile(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

        //read in the shape files and place them on the Queue

        while(in.hasNext()) {
            String ShapeType=in.next();
            if(ShapeType.equals("circle")){
                Circle circle=CircleInput(in);
                shapeQueue.enqueue(circle);
            }
            else if(ShapeType.equals("oval")){
                Oval oval=OvalInput(in);
                shapeQueue.enqueue(oval);
            }
            else if(ShapeType.equals("rect")) {
                Rect rect = RectInput(in);
                shapeQueue.enqueue(rect);
            }
            else if(ShapeType.equals("square")) {
                Square square = SquareInput(in);
                shapeQueue.enqueue(square);
            }
            else if(ShapeType.equals("hexagon")) {
                Hexagon hexagon = HexagonInput(in);
                shapeQueue.enqueue(hexagon);
            }
        }


        //Right now, returning an empty Queue.  You need to change this.
       // shapeQueue.print();
        return shapeQueue;
    }

    /**
     * Method to read the file and return a queue of shapes from this file. The
     * program should handle the file not found exception here and shut down the
     * program gracefully.
     *
     * @param filename
     *            the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename) {
        // HINT: You might want to open a file here.

        File inputFile=new File(filename);
        Scanner in = new Scanner(System.in); //null is not sensible. Please change

        try{
            in=new Scanner(inputFile);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!!! "+filename);
            System.exit(1);
        }
        
        return ReadShapeFile.readDataFile(in);
        
    }
}

