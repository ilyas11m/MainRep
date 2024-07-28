import java.awt.*;

public class Ellipse extends Circle {
    protected int semiMajorAxis;
    protected int semiMinorAxis;

    public Ellipse(int x, int y, int semiMajorAxis, int semiMinorAxis) {
        super(x, y, semiMinorAxis);
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    @Override
    public void draw(Graphics g2D) {
        if (visible) {
            g2D.drawOval(x - semiMajorAxis, y - semiMinorAxis, 2 * semiMajorAxis, 2 * semiMinorAxis);
        }
    }

    public void decreaseSize() {
        semiMajorAxis = Math.max(5, semiMajorAxis - 5);
        semiMinorAxis = Math.max(5, semiMinorAxis - 5);
    }
    public void increaseSize() {
        semiMajorAxis += 5;
        semiMinorAxis += 5;
    }

    public void flip() {
        int temp = semiMajorAxis;
        semiMajorAxis = semiMinorAxis;
        semiMinorAxis = temp;
    }

    public void setSemiMajorAxis (int newSemiMajorAxis) {
        semiMajorAxis = newSemiMajorAxis;
    }
    public void setSemiMinorAxis (int newSemiMinorAxis) {
        semiMinorAxis = newSemiMinorAxis;
    }
}
