import java.awt.*;

abstract class TFigure {
    protected int x, y;
    protected boolean visible = true;


    public TFigure (int x, int y) {
        this.x =x;
        this.y =y;
    }

    public void MoveTo(int dx, int dy, Graphics g2D) {
        x = x + dx;
        y = y + dy;
        draw(g2D);
    }

    public void Show() {
        visible = !visible;
    }

    public void draw(Graphics g2D) {}


    public abstract void increaseSize();

    public abstract void decreaseSize();
}
