import java.awt.*;

class Triangle extends TFigure {
    protected int size;
    protected Color color;

    public Triangle(int x, int y, int size) {
        super(x,y);
        this.size = size;
    }

    public Triangle(int x, int y, int size, Color c) {
        super(x,y);
        this.size = size;
        color = c;
    }

     @Override
     public void draw(Graphics g2D) {
         if (visible) {
             g2D.setColor(color);
             int[] xPoints = {x, x - size / 2, x + size / 2};
             int[] yPoints = {y, y + size, y + size};
             g2D.drawPolygon(xPoints, yPoints, 3);
         }
     }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSize(int newSize) {
        size = newSize;
    }
     @Override
    public void increaseSize() {
        size += 5;
    }

    public void decreaseSize() {
        size = Math.max(5, size - 5);
    }

    public void Show() {
        visible = !visible;
    }
}

