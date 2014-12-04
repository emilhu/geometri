package geometri;

import java.awt.Color;

/**
 * An abstract class for the instance variables and methods that all GeometricalForms uses.
 *
 * @author Emil Hukic
 * @author Tobias Hallberg
 */
public abstract class RectangularForm implements GeometricalForm {

    /**
     * X position from top left corner
     */
    protected int x;
    /**
     * Y position from top left corner
     */
    protected int y;
    /**
     * The width of the form
     */

    protected int width;
    /**
     * The height of the form
     */
    protected int height;
    /**
     * Color of the form
     */
    protected Color c;

    /**
     * {@inheritDoc}
     */
    public int getX() {
        return x;
    }

    /**
     * {@inheritDoc}
     */
    public int getY() {
        return y;
    }

    /**
     * {@inheritDoc}
     */
    public int getHeight() {
        return height;
    }

    /**
     * {@inheritDoc}
     */
    public int getWidth() {
        return width;
    }

    /**
     * {@inheritDoc}
     */
    public Color getColor() {
        return c;
    }

    /**
     * compares the area and perimeter of the GeometricalForm and the given object
     * @param f A GeometricalForm
     * @return
     */
    public int comparison (GeometricalForm f)   {
        if (this.getArea() > f.getArea()) {
            return 1;
        }   else if (this.getArea() < f.getArea()) {
            return -1;
        }   else if (this.getPerimeter() > f.getPerimeter())    {
            return 1;
        }   else if (this.getPerimeter() < f.getPerimeter())    {
            return -1;
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public void move( int dx, int dy ) throws IllegalPositionException {
        this.x += dx;
        this.y += dy;
    }

    /**
     * {@inheritDoc}
     */
    public void place( int x, int y )throws IllegalPositionException {
        this.x = x;
        this.y = y;
    }

}
