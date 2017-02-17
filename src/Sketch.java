import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * Created by maurn on 2/17/17.
 */
public class Sketch extends PApplet {
    private ArrayList<Disc> discs;

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
    }

    public void draw() {
        background(0);

        float r = 0;
        float interval = (2 * PI) / discs.size();
        PVector center = new PVector(width / 2, height / 2);
        PVector target = new PVector(-1, -1);
        target.setMag(sin(frameCount*0.1f)*100);
        target.rotate(noise(frameCount*0.01f));
        for (Disc disc : discs) {
            target.rotate(r);
            PVector loc = PVector.add(center, target);
            disc.setLocation(loc);
            r += interval;

            disc.display();
        }

        text(frameRate, 100, 100);
    }
}