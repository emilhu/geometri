package geometri;

import java.awt.Color;

/**
 * Created by Emil H on 2014-11-24.
 */
public abstract class Form implements GeometricalForm {

    int x;
    int y;
    int width;
    int height;
    Color c;

    public Form (Point a, Point b){
        this.x = a.getX();
        this.y = a.getY();
        this.width = b.getX() - x;
        this.height = b.getY() - y;
    }

    public Form () {
        x = 0;
        y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return c;
    }

    public void move( int dx, int dy ) throws IllegalPositionException {

    }

    public void place( int x, int y )throws IllegalPositionException {

    }

}
