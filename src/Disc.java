import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;

/**
 * Created by maurn on 2/17/17.
 */
public class Disc {
    private PApplet parent;
    private PVector location;

    private PShape shape;

    public Disc(PApplet parent, PVector location, float radius, int nCircles) {
        this.parent = parent;
        this.location = location;

        shape = parent.createShape(PConstants.GROUP);

        for (int i = 1; i <= nCircles; i++) {
            float r = radius - 40 * i;
            shape.addChild(parent.createShape(PConstants.ELLIPSE, 0, 0, r, r));
        }
    }

    public void setLocation(PVector location) {
        this.location = location;
    }

    public void display() {
        parent.pushMatrix();
        parent.translate(location.x, location.y);
        parent.shape(this.shape);
        parent.popMatrix();
    }
}
