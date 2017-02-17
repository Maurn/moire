import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by maurn on 2/17/17.
 */
public class LineDisc {
    private PApplet parent;
    private PVector location;
    private float radius;
    private int nLines;

    public LineDisc(PApplet parent, PVector location, float radius, int nLines) {
        this.parent = parent;
        this.location = location;
        this.radius = radius;
        this.nLines = nLines;
    }

    public PVector getLocation() {
        return location;
    }

    public void setLocation(PVector location) {
        this.location = location;
    }

    public void display() {
        float step = (2 * parent.PI) / nLines;
        for (float i = 0; i < 2 * parent.PI; i += step)
            parent.line(location.x, location.y, location.x+radius * parent.cos(i), location.y+radius * parent.sin(i));
    }
}
