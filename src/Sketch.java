import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * Created by maurn on 2/17/17.
 */
public class Sketch extends PApplet {
    private ArrayList<Disc> discs;

    private PVector center;
    private float interval;

    public void settings() {
        fullScreen(2);
    }

    public void setup() {
        noFill();
        stroke(255);
        strokeWeight(3);

        discs = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            discs.add(new Disc(this, new PVector(width / 2, height / 2), 500, 20));
        }

        center = new PVector(width / 2, height / 2);
        interval = (2 * PI) / discs.size();
    }

    public void draw() {
        background(0);

        float r = 0;

        PVector target = new PVector(-1, -1);
        target.setMag(PVector.sub(new PVector(mouseX, mouseY), center).mag() * 0.3f);
        target.rotate(atan2(mouseY - height / 2, mouseX - width / 2));
        for (Disc disc : discs) {
            target.rotate(r);
            disc.setLocation(PVector.add(center, target));
            r += interval;

            disc.display();
        }

        text(frameRate, 50, 50);
    }
}
