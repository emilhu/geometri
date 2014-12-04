package geometri;
import java.awt.*;

/**
 * A Line with two points (x1,y1) and (x2,y2), and a color.
 *
 * @author Emil Hukic
 * @author Tobias Hallberg
 */
public class Line extends RectangularForm implements GeometricalForm {

    /**
     * boolean for if the line is drawn from the bottom
     */
    private boolean upwardLine;
    /**
     * Creates a Line from two coordinates (x1,y1) to (x2,y2), and a color.
     * @param x1 The first X coordinate
     * @param y1 The first Y coordinate
     * @param x2 The second X coordinate
     * @param y2 The second Y coordinate
     * @param c The Color
     * @throws IllegalPositionException Is thrown if trying to set a negative position
     */
    public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException {
        this.x = x1;
        this.y = y1;
        this.width = Math.abs(x1-x2);
        this.height = Math.abs(y1-y2);
        this.upwardLine = y > y2;
    }
    /**
     * Creates a Line from two GeometricalForms and a color.
     * @param f1 A GeometricalForm
     * @param f2 A GeometricalForm
     * @param c The Color
     */
    public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
        this.x = f1.getX();
        this.y = f1.getY();
        this.width = f2.getWidth();
        this.height = f2.getHeight();
    }
    /**
     * {@inheritDoc}
     */
    public int getPerimeter () {
        return (int) Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    /**
     * {@inheritDoc}
     */
    public int getArea () {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int compareTo(GeometricalForm f) {
        if ( f.getClass() != this.getClass()) {
            return -1;
        }
        return comparison(f);
    }

    /**
     * {@inheritDoc}
     */
    public void fill( Graphics g ) {
        if (upwardLine)  {
            g.drawLine(x+width,y, x, y+height);
        }   else {
            g.drawLine(x,y,x+width,y+height);
        }
    }

    /**
     * {@inheritDoc}
     * @override
     */
    public boolean equals (Object otherObject) {
        if (this == otherObject) {
            return true;
        }   else if (otherObject == null)    {
            return false;
        }   else if (otherObject.getClass() != this.getClass()) {
            return false;
        }
        Line other = (Line) otherObject;
        return this.equals(other) && this.getColor() == other.getColor() && this.getHeight() == other.getHeight()
                && this.getWidth() == other.getWidth() && this.upwardLine == other.upwardLine;
    }

    /**
     * {@inheritDoc}
     * @override
     */
    public int hashCode() {
        return 7*c.hashCode() + 9 * getHeight() + 9 * getWidth();
    }
}
