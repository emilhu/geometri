package geometri;
import java.awt.*;

/**
 * A Circle with a size, position and color.
 *
 * @author Emil Hukic
 * @author Tobias Hallberg
 */
public class Circle extends RectangularForm implements GeometricalForm {

    /**
     * Creates a Circle from a position, diameter and color.
     * @param x X coordinate from top left corner
     * @param y Y coordinate from top left corner
     * @param diameter The diameter
     * @param c The color
     * @throws IllegalPositionException Is thrown if trying to set a negative position
     */
    public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException {
        this.x = x;
        this.y = y;
        this.width = diameter;
        this.height = diameter;
        this.c = c;
    }

    /**
     * Creates a Circle with the same position as an already given GeometricalForm, a new diameter and color.
     * @param f A circle
     * @param diameter The diameter
     * @param c The color
     */
    public Circle(GeometricalForm f, int diameter, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.width = diameter;
        this.height = diameter;

    }


    /**
     * {@inheritDoc}
     */
    public int getPerimeter () {
        return (int)(2 * Math.PI * getWidth()/2)  ;
    }

    /**
     * {@inheritDoc}
     */
    public int getArea () {
        return (int)(getWidth()/2*getWidth()/2*Math.PI);
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
        g.drawOval(x,y,width,height);
        g.setColor(c);
    }

    public boolean equals (Object otherObject) {
        if (this == otherObject) {
            return true;
        }   else if (otherObject == null)    {
            return false;
        }   else if (otherObject.getClass() != this.getClass()) {
            return false;
        }
        Circle other = (Circle) otherObject;
        return this.equals(other) && this.getColor() == other.getColor() && this.getHeight() == other.getHeight()
                && this.getWidth() == other.getWidth();
    }

    public int hashCode() {
        return 23*c.hashCode() + 13 * getHeight() + 31 * getWidth();
    }
}
