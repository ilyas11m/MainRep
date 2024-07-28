import java.awt.*;

class Circle extends TFigure {
    protected int radius;
    protected Color color;

    public Circle(int x, int y, int radius) {
        super(x,y);
        this.radius = radius;
    }

    public Circle(int x, int y, int radius, Color c) {
        super(x,y);
        this.radius = radius;
        color = c;
    }

    @Override
    public void draw(Graphics g2D) {
        if (visible) {
            g2D.setColor(color);
            g2D.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRadius(int newRadius) {
        radius = newRadius;
    }

    @Override
    public void increaseSize() {
        radius += 5;
    }

    public void decreaseSize() {
        radius = Math.max(5, radius - 5);
    }

    public void Show() {
        visible = !visible;
    }
}
