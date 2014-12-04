package geometri;
import java.awt.*;

/**
 * An Oval with a size, position and color.
 *
 * @author Emil Hukic
 * @author Tobias Hallberg
 */
public class Oval extends RectangularForm implements GeometricalForm {

    /**
     * Creates an Oval with a position, height, width and color.
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param width The width
     * @param height The height
     * @param c The Color
     * @throws IllegalPositionException Is thrown if trying to set a negative position
     */
    public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }

    /**
     * Creates an Oval with the same position as an already given GeometricalForm, a new height, width and color.
     * @param f A GeometricalForm
     * @param width The width
     * @param height The height
     * @param c The color
     */
    public Oval(GeometricalForm f, int width, int height, Color c) {
        x = f.getX();
        y = f.getY();
        this.width = width;
        this.height = height;
        this.c = c;
    }

    /**
     * {@inheritDoc}
     */
    public int getPerimeter () {
        int a = getHeight();
        int b = getWidth();
        return (int)(Math.PI*Math.abs(3 *(a + b) - Math.sqrt((3*a + b)*(a + 3*b))));
    }

    /**
     * {@inheritDoc}
     */
    public int getArea () {
        return (int)(Math.PI * getHeight()/2 * getWidth()/2);
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

    /**
     * {@inheritDoc}
     * @override
     */
    public boolean equals (Object otherObject) {
        Oval other = (Oval) otherObject;
        return super.equals(other) && this.getHeight() == other.getHeight()
                && this.getWidth() == other.getWidth();
    }

    /**
     * {@inheritDoc}
     * @override
     */
    public int hashCode() {
        return 13*c.hashCode() + 7 * getHeight() + 9 * getWidth();
    }
}