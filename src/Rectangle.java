import java.awt.*;

public class Rectangle extends Square {
    protected int length;
    protected int height;

    public Rectangle (int x, int y, int length, int height) {
        super(x,y, length);
        this.height = height;
        this.length = length;
    }
    @Override
    public void draw(Graphics g2D) {
        if (visible) {
            g2D.drawRect(x, y, length, height);
        }
    }
    public void decreaseSize() {
        length -= 5;
        height -= 5;
    }
    public void increaseSize() {
        length += 5;
        height += 5;
    }

    public void setHeight(int newHeight) {
        height = newHeight;
    }
    public void setLength(int newLength) {
        length = newLength;
    }

}
