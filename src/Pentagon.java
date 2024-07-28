import java.awt.*;

public class Pentagon extends Triangle {
    protected int sideLength;

    public Pentagon (int x, int y, int size, int sideLength){
        super(x, y, size);
        this.sideLength = sideLength;
    }
    @Override
    public void draw(Graphics g2D) {
        if (visible) {
            int[] xPoints = {
                    x,
                    x + sideLength / 2,
                    x + (int) (sideLength * 0.5 * Math.cos(Math.toRadians(50))),
                    x - (int) (sideLength * 0.5 * Math.cos(Math.toRadians(50))),
                    x - sideLength / 2
            };
            int[] yPoints = {
                    y - sideLength,
                    y - sideLength / 2,
                    y + (int) (sideLength * 0.5 * Math.sin(Math.toRadians(50))),
                    y + (int) (sideLength * 0.5 * Math.sin(Math.toRadians(50))),
                    y - sideLength / 2
            };
            g2D.drawPolygon(xPoints, yPoints, 5);
        }
    }
    public void setSideLength(int newSideLength) {
        sideLength = newSideLength;
    }
    public void increaseSize() {
        sideLength += 10;
    };
    public void decreaseSize() {
        sideLength = Math.max(5, sideLength - 5);
    }
}
