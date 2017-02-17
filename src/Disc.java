import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by maurn on 2/17/17.
 */
public class Disc {
    private PApplet parent;
    private PVector location;
    private float radius;
    private int nCircles;

    public Disc(PApplet parent, PVector location, float radius, int nCircles) {
        this.parent = parent;
        this.location = location;
        this.radius = radius;
        this.nCircles = nCircles;
    }

    public void setLocation(PVector location) {
        this.location = location;
    }

    public void display() {
        parent.colorMode(parent.HSB);
        for (int i = 1; i <= nCircles; i++) {
            parent.stroke(parent.map(i,0,nCircles,50,150),255,255);
            float r = radius - 40 * i;
            parent.ellipse(location.x, location.y, r, r);
        }
    }
}
