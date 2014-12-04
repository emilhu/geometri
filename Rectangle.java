package geometri;

import java.awt.*;

/**
 * A Rectangle with a size, position and color.
 *
 * @author Emil Hukic
 * @author Tobias Hallberg
 */
public class Rectangle extends RectangularForm implements GeometricalForm {

    /**
     * Creates a Rectangle from a position, width, height and color.
     * @param x X coordinate
     * @param y Y coordinate
     * @param width The width
     * @param height The height
     * @param c The color
     * @throws IllegalPositionException Is thrown if trying to set a negative position
     */
    public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;

    }

    /**
     * Creates a Rectangle with the same position as an already given GeometricalForm, a new width and height, and a color.
     * @param f A GeometricalForm
     * @param width The width
     * @param height The height
     * @param c The color
     */
    public Rectangle(GeometricalForm f, int width, int height, Color c) {
        this.x = f.getX();
        this.y = f.getY();
        this.width = width;
        this.height = height;
        this.c = c;
    }

    /**
     * {@inheritDoc}
     */
    public int getPerimeter () {
        return 2 * (width + height);
    }

    /**
     * {@inheritDoc}
     */
    public int getArea () {
        return height*width;
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
        g.drawRect(x, y, width, height);
        g.setColor(c);
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals (Object otherObject) {
        if (this == otherObject) {
            return true;
        }   else if (otherObject == null)    {
            return false;
        }   else if (otherObject.getClass() != this.getClass()) {
            return false;
        }
        Rectangle other = (Rectangle) otherObject;
        return this.equals(other) && this.getColor() == other.getColor() && this.getHeight() == other.getHeight()
        && this.getWidth() == other.getWidth();
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return 3*c.hashCode() + 7 * getHeight() + 9 * getWidth();
    }
}