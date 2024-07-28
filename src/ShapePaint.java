import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class ShapePaint {
    private final DrawingPanel drawPanel;
    private final Random random = new Random();
    private Square[] squares;
    private Triangle[] triangles;
    private Circle[] circles;
    private Ellipse[] ellipses;
    private Rectangle[] rectangles;
    private Pentagon[] pentagons;
    private TFigure[] massive = null;

    private Square square;
    private Triangle triangle;
    private Circle circle;
    private Ellipse ellipse;
    private Rectangle rectangle;
    private Pentagon pentagon;
    private boolean squaresArray = false;
    private boolean trianglesArray = false;
    private boolean circlesArray = false;
    private boolean shapesArray = false;
    private Graphics2D g2D;

    public ShapePaint() {
        squares = new Square[0];
        triangles = new Triangle[0];
        circles = new Circle[0];
        ellipses = new Ellipse[0];
        rectangles = new Rectangle[0];
        pentagons = new Pentagon[0];

        JFrame frame = new JFrame("Random Shape Drawing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);

        drawPanel = new DrawingPanel();

        JButton drawSquareButton = new JButton("Квадрат");
        JButton drawTriangleButton = new JButton("Треугольник");
        JButton drawCircleButton = new JButton("Круг");
        JButton drawEllipseButton = new JButton("Эллипс");
        JButton drawRectangleButton = new JButton("Прямоугольник");
        JButton drawPentagonButton = new JButton("Пятиугольник");

        JButton drawArrayOfSquaresButton = new JButton("Квадраты");
        JButton drawArrayOfTrianglesButton = new JButton("Треугольники");
        JButton drawArrayOfCirclesButton = new JButton("Круги");
        JButton drawArrayOfAllShapesButton = new JButton("Массив фигур");

        JButton moveUpButton = new JButton("Вверх");
        JButton moveDownButton = new JButton("Вниз");
        JButton moveLeftButton = new JButton("Влево");
        JButton moveRightButton = new JButton("Вправо");

        JButton increaseSizeCircleButton = new JButton(" + размер кругов");
        JButton decreaseSizeCircleButton = new JButton(" - размер кругов");
        JButton flipButton = new JButton("Переворот эллипса");

        JButton increaseSizeRectangleButton = new JButton(" + размер четырехугольников");
        JButton decreaseSizeRectangleButton = new JButton(" - размер четырехугольников");

        JButton increaseSizeTriangleButton = new JButton(" + размер треугольников");
        JButton decreaseSizeTriangleButton = new JButton(" - размер треугольников");

        JButton moveSquaresButton = new JButton("Перемещение четырехугольников");
        JButton moveTrianglesButton = new JButton("Перемещение треугольников");
        JButton moveCirclesButton = new JButton("Перемещение кругов");
        JButton movesRectanglesButton = new JButton("Перемещение прямоугольников");


        JButton increaseSizeButton = new JButton(" + размер");
        JButton decreaseSizeButton = new JButton(" - размер");

        JButton showSquareMethodButton = new JButton("Видимость:четырехугольники");
        JButton showCircleMethodButton = new JButton("Видимость:круги");
        JButton showTriangleMethodButton = new JButton("Видимость:треугольники");

        JButton removeArrayOfSquaresButton = new JButton("Удалить м. кв.");
        JButton removeArrayOfCirclesButton = new JButton("Удалить м. кр.");
        JButton removeArrayOfTrianglesButton = new JButton("Удалить м. тре.");

        JButton clearCanvasButton = new JButton("Очистить");


        drawSquareButton.addActionListener(e -> drawRandomSquare());
        drawCircleButton.addActionListener(e -> drawRandomCircle());
        drawTriangleButton.addActionListener(e -> drawRandomTriangle());
        drawEllipseButton.addActionListener(e -> drawRandomEllipse());
        drawRectangleButton.addActionListener(e -> drawRandomRectangle());
        drawPentagonButton.addActionListener(e -> drawRandomPentagon());
        drawArrayOfSquaresButton.addActionListener(e -> drawArrayOfSquares());
        drawArrayOfCirclesButton.addActionListener(e -> drawArrayOfCircles());
        drawArrayOfTrianglesButton.addActionListener(e -> drawArrayOfTriangles());
        drawArrayOfAllShapesButton.addActionListener(e -> drawArrayOfAllShapes());
        moveUpButton.addActionListener(e -> MoveTo(0, -20));
        moveDownButton.addActionListener(e -> MoveTo(0, 20));
        moveLeftButton.addActionListener(e -> MoveTo(-20, 0));
        moveRightButton.addActionListener(e -> MoveTo(20, 0));
        increaseSizeCircleButton.addActionListener(e -> increaseSizeCircles());
        decreaseSizeCircleButton.addActionListener(e -> decreaseSizeCircles());
        flipButton.addActionListener(e -> flip());
        increaseSizeRectangleButton.addActionListener(e -> increaseSizeSquares());
        decreaseSizeRectangleButton.addActionListener(e -> decreaseSizeSquares());
        increaseSizeTriangleButton.addActionListener(e -> increaseSizeTriangles());
        decreaseSizeTriangleButton.addActionListener(e -> decreaseSizeTriangles());
        moveSquaresButton.addActionListener(e -> moveSquaresDown());
        moveTrianglesButton.addActionListener(e -> moveTrianglesDown());
        moveCirclesButton.addActionListener(e -> moveCirclesDown());
        movesRectanglesButton.addActionListener(e -> moveRectanglesDown());
        increaseSizeButton.addActionListener(e -> increaseSize());
        decreaseSizeButton.addActionListener(e -> decreaseSize());
        showSquareMethodButton.addActionListener(e -> Show(Square.class));
        showCircleMethodButton.addActionListener(e -> Show(Circle.class));
        showTriangleMethodButton.addActionListener(e -> Show(Triangle.class));
        removeArrayOfSquaresButton.addActionListener(e -> removeArrayOfSquares());
        removeArrayOfCirclesButton.addActionListener(e -> removeArrayOfCircles());
        removeArrayOfTrianglesButton.addActionListener(e -> removeArrayOfTriangles());
        clearCanvasButton.addActionListener(e -> clearCanvas());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(drawSquareButton);
        buttonPanel.add(drawCircleButton);
        buttonPanel.add(drawTriangleButton);

        buttonPanel.add(drawEllipseButton);
        buttonPanel.add(drawRectangleButton);
        buttonPanel.add(drawPentagonButton);
        buttonPanel.add(drawArrayOfSquaresButton);
        buttonPanel.add(drawArrayOfCirclesButton);
        buttonPanel.add(drawArrayOfTrianglesButton);
        buttonPanel.add(drawArrayOfAllShapesButton);


        JPanel showButtonPanel = new JPanel();
        showButtonPanel.add(showSquareMethodButton);
        showButtonPanel.add(showCircleMethodButton);
        showButtonPanel.add(showTriangleMethodButton);

        JPanel moveButtonPanel = new JPanel();
        moveButtonPanel.add(moveUpButton);
        moveButtonPanel.add(moveDownButton);
        moveButtonPanel.add(moveLeftButton);
        moveButtonPanel.add(moveRightButton);
        moveButtonPanel.add(moveSquaresButton);
        moveButtonPanel.add(moveTrianglesButton);
        moveButtonPanel.add(moveCirclesButton);
        moveButtonPanel.add(movesRectanglesButton);

        JPanel sizeButtonPanel = new JPanel();
        sizeButtonPanel.add(increaseSizeButton);
        sizeButtonPanel.add(decreaseSizeButton);
        sizeButtonPanel.add(increaseSizeCircleButton);
        sizeButtonPanel.add(decreaseSizeCircleButton);
        sizeButtonPanel.add(flipButton);
        sizeButtonPanel.add(increaseSizeRectangleButton);
        sizeButtonPanel.add(decreaseSizeRectangleButton);
        sizeButtonPanel.add(increaseSizeTriangleButton);
        sizeButtonPanel.add(decreaseSizeTriangleButton);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setPreferredSize(new Dimension(200, 170));
        controlPanel.add(buttonPanel);
        controlPanel.add(sizeButtonPanel);
        controlPanel.add(moveButtonPanel);
        controlPanel.add(showButtonPanel);
        controlPanel.add(removeArrayOfSquaresButton);
        controlPanel.add(removeArrayOfCirclesButton);
        controlPanel.add(removeArrayOfTrianglesButton);
        controlPanel.add(clearCanvasButton);


        frame.setLayout(new BorderLayout());
        frame.add(drawPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        buttonPanel.setBackground(Color.darkGray);
        moveButtonPanel.setBackground(Color.darkGray);
        sizeButtonPanel.setBackground(Color.darkGray);
        showButtonPanel.setBackground(Color.darkGray);
        controlPanel.setBackground(Color.darkGray);

        frame.setSize(400, 400);
        frame.setVisible(true);


    }

    class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g2D = (Graphics2D) g;
            super.paintComponent(g);
            for (Square square : squares) {
                square.draw(g2D);
            }
            for (Triangle triangle : triangles) {
                triangle.draw(g2D);
            }
            for (Circle circle : circles) {
                circle.draw(g2D);
            }
            for (Ellipse ellipse : ellipses) {
                ellipse.draw(g2D);
            }
            for (Rectangle rectangle : rectangles) {
                rectangle.draw(g2D);
            }
            for (Pentagon pentagon : pentagons) {
                pentagon.draw(g2D);
            }
        }
    }



    public void drawRandomSquare() {
        int x = random.nextInt(drawPanel.getWidth());
        int y = random.nextInt(drawPanel.getHeight());
        int size = random.nextInt(200) + 15;
        if (square == null) {
            square = new Square(x, y, size, Color.MAGENTA);
            squares = Arrays.copyOf(squares, squares.length + 1);
            squares[squares.length - 1] = square;
        } else {
            square.MoveTo(x - square.getX(), y - square.getY(),g2D);
            square.setSize(size);
        }
        drawPanel.repaint();
    }

    public void drawRandomRectangle() {
        int x = random.nextInt(drawPanel.getWidth());
        int y = random.nextInt(drawPanel.getHeight());
        int length = random.nextInt(200) + 15;
        int height = random.nextInt(200) + 15;
        if (rectangle == null) {
            rectangle = new Rectangle(x, y, length, height);
            rectangles = Arrays.copyOf(rectangles, rectangles.length + 1);
            rectangles[rectangles.length - 1] = rectangle;
        } else {
            rectangle.MoveTo(x - rectangle.getX(), y - rectangle.getY(), g2D);
            rectangle.setLength(length);
            rectangle.setHeight(height);
        }
        drawPanel.repaint();
    }


    public void drawRandomTriangle() {
        int x = random.nextInt(drawPanel.getWidth());
        int y = random.nextInt(drawPanel.getHeight());
        int size = random.nextInt(200) + 15;
        if (triangle == null) {
            triangle = new Triangle(x, y, size, Color.ORANGE);
            triangles = Arrays.copyOf(triangles, triangles.length + 1);
            triangles[triangles.length - 1] = triangle;
        } else {
            triangle.MoveTo(x - triangle.getX(), y - triangle.getY(), g2D);
            triangle.setSize(size);
        }
        drawPanel.repaint();
    }

    public void drawRandomPentagon() {
        int x = random.nextInt(drawPanel.getWidth());
        int y = random.nextInt(drawPanel.getHeight());
        int size = random.nextInt(200) + 15;
        int sideLength = random.nextInt(200) + 15;
        if (pentagon == null) {
            pentagon = new Pentagon(x, y, size, sideLength);
            pentagons = Arrays.copyOf(pentagons, pentagons.length + 1);
            pentagons[pentagons.length - 1] = pentagon;
        } else {
            pentagon.MoveTo(x - pentagon.getX(), y - pentagon.getY(), g2D);
            pentagon.setSize(size);
            pentagon.setSideLength(sideLength);
        }
        drawPanel.repaint();
    }


    public void drawRandomCircle() {
        int x = random.nextInt(drawPanel.getWidth());
        int y = random.nextInt(drawPanel.getHeight());
        int radius = random.nextInt(200) + 15;
        if (circle == null) {
            circle = new Circle(x, y, radius, Color.BLUE);
            circles = Arrays.copyOf(circles, circles.length + 1);
            circles[circles.length - 1] = circle;
        } else {
            circle.MoveTo(x - circle.getX(), y - circle.getY(), g2D);
            circle.setRadius(radius);
        }
        drawPanel.repaint();
    }
    public void drawRandomEllipse() {
        int x = random.nextInt(drawPanel.getWidth());
        int y = random.nextInt(drawPanel.getHeight());
        int semiMajorAxis = random.nextInt(150) + 20;
        int semiMinorAxis = random.nextInt(200) + 15;
        if (ellipse == null) {
            ellipse = new Ellipse(x, y, semiMajorAxis, semiMinorAxis);
            ellipses = Arrays.copyOf(ellipses, ellipses.length + 1);
            ellipses[ellipses.length - 1] = ellipse;
        } else {
            ellipse.MoveTo(x - ellipse.getX(), y - ellipse.getY(), g2D);
            ellipse.setSemiMajorAxis(semiMajorAxis);
            ellipse.setSemiMinorAxis(semiMinorAxis);
        }
        drawPanel.repaint();
    }

    public void drawArrayOfSquares() {
        if (!squaresArray) {
            squares = new Square[10];
            for (int i = 0; i < 10; i++) {
                int x = random.nextInt(drawPanel.getWidth());
                int y = random.nextInt(drawPanel.getHeight());
                int size = random.nextInt(250) + 15;
                squares[i] = new Square(x, y, size, Color.MAGENTA);
            }
            squaresArray = true;
        } else {
            JOptionPane.showMessageDialog(null, "Массив квадратов уже создан.");
        }
        drawPanel.repaint();
    }

    public void drawArrayOfCircles() {
        if (!circlesArray) {
            circles = new Circle[10];
            for (int i = 0; i < 10; i++) {
                int x = random.nextInt(drawPanel.getWidth());
                int y = random.nextInt(drawPanel.getHeight());
                int radius = random.nextInt(250) + 15;
                circles[i] = new Circle(x, y, radius, Color.BLUE);
            }
            circlesArray = true;
        } else {
            JOptionPane.showMessageDialog(null, "Массив кругов уже создан.");
        }
        drawPanel.repaint();
    }

    public void drawArrayOfTriangles() {
        if (!trianglesArray) {
            triangles = new Triangle[10];
            for (int i = 0; i < 10; i++) {
                int x = random.nextInt(drawPanel.getWidth());
                int y = random.nextInt(drawPanel.getHeight());
                int size = random.nextInt(250) + 15;
                triangles[i] = new Triangle(x, y, size, Color.ORANGE);
            }
            trianglesArray = true;
        } else {
            JOptionPane.showMessageDialog(null, "Массив треугольников уже создан.");
        }
        drawPanel.repaint();
    }

    public void drawArrayOfAllShapes() {
        Random random = new Random();
        if (!shapesArray) {
            massive = new TFigure[30];
            for (int i = 0; i < 30; i++) {
                int x = random.nextInt(drawPanel.getWidth());
                int y = random.nextInt(drawPanel.getHeight());

                int shapeType = random.nextInt(6);

                switch (shapeType) {
                    case 0:
                        int size = random.nextInt(200) + 15;
                        massive[i] = new Square(x, y, size, Color.MAGENTA);
                        break;
                    case 1:
                        int length = random.nextInt(200) + 15;
                        int height = random.nextInt(200) + 15;
                        massive[i] = new Rectangle(x, y, length, height);
                        break;
                    case 2:
                        int triangleSize = random.nextInt(200) + 15;
                        massive[i] = new Triangle(x, y, triangleSize, Color.ORANGE);
                        break;
                    case 3:
                        int sideLength = random.nextInt(200) + 15;
                        int pentagonSize = random.nextInt(200) + 15;
                        massive[i] = new Pentagon(x, y, pentagonSize, sideLength);
                        break;
                    case 4:
                        int radius = random.nextInt(200) + 15;
                        massive[i] = new Circle(x, y, radius, Color.BLUE);
                        break;
                    case 5:
                        int semiMajorAxis = random.nextInt(150) + 20;
                        int semiMinorAxis = random.nextInt(200) + 15;
                        massive[i] = new Ellipse(x, y, semiMajorAxis, semiMinorAxis);
                        break;
                }
            }

            for (TFigure shape : massive) {
                if (shape instanceof Square) {
                    squares = Arrays.copyOf(squares, squares.length + 1);
                    squares[squares.length - 1] = (Square) shape;
                } else if (shape instanceof Triangle) {
                    triangles = Arrays.copyOf(triangles, triangles.length + 1);
                    triangles[triangles.length - 1] = (Triangle) shape;
                } else if (shape instanceof Circle) {
                    circles = Arrays.copyOf(circles, circles.length + 1);
                    circles[circles.length - 1] = (Circle) shape;
                }
            }
            shapesArray = true;
            drawPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Массив фигур уже создан!");
        }
    }

    public void MoveTo(int dx, int dy) {
        for (Square square : squares) {
            square.MoveTo(dx, dy, g2D);
        }
        for (Triangle triangle : triangles) {
            triangle.MoveTo(dx, dy, g2D);
        }
        for (Circle circle : circles) {
            circle.MoveTo(dx, dy, g2D);
        }
        for (Ellipse ellipse : ellipses) {
            ellipse.MoveTo(dx, dy, g2D);
        }
        for (Rectangle rectangle : rectangles) {
            rectangle.MoveTo(dx, dy, g2D);
        }
        for (Pentagon pentagon : pentagons) {
            pentagon.MoveTo(dx, dy, g2D);
        }
        if (square != null) {
            square.MoveTo(dx, dy, g2D);
        }
        if (triangle != null) {
            triangle.MoveTo(dx, dy, g2D);
        }
        if (circle != null) {
            circle.MoveTo(dx, dy, g2D);
        }
        if (ellipse != null) {
            ellipse.MoveTo(dx, dy, g2D);
        }
        if (rectangle != null) {
            rectangle.MoveTo(dx, dy, g2D);
        }
        if (pentagon != null) {
            pentagon.MoveTo(dx, dy, g2D);
        }
        drawPanel.repaint();
    }

    public void increaseSize() {
        for (Square square : squares) {
            square.increaseSize();
        }
        for (Triangle triangle : triangles) {
            triangle.increaseSize();
        }
        for (Circle circle : circles) {
            circle.increaseSize();
        }
        for (Ellipse ellipse : ellipses) {
            ellipse.increaseSize();
        }
        for (Rectangle rectangle : rectangles) {
            rectangle.increaseSize();
        }
        for (Pentagon pentagon : pentagons) {
            pentagon.increaseSize();
        }
        if (pentagon != null) {
            pentagon.increaseSize();
        }
        if (ellipse != null) {
            ellipse.increaseSize();
        }
        if (square != null) {
            square.increaseSize();
        }
        if (triangle != null) {
            triangle.increaseSize();
        }
        if (circle != null) {
            circle.increaseSize();
        }
        if (rectangle != null) {
            rectangle.increaseSize();
        }
        drawPanel.repaint();
    }

    public void decreaseSize() {
        for (Square square : squares) {
            square.decreaseSize();
        }
        for (Triangle triangle : triangles) {
            triangle.decreaseSize();
        }
        for (Circle circle : circles) {
            circle.decreaseSize();
        }
        for (Ellipse ellipse : ellipses) {
            ellipse.decreaseSize();
        }
        for (Rectangle rectangle : rectangles) {
            rectangle.decreaseSize();
        }
        for (Pentagon pentagon : pentagons) {
            pentagon.decreaseSize();
        }
        if (pentagon != null) {
            pentagon.decreaseSize();
        }
        if (square != null) {
            square.decreaseSize();
        }
        if (triangle != null) {
            triangle.decreaseSize();
        }
        if (circle != null) {
            circle.decreaseSize();
        }
        if (ellipse != null) {
            ellipse.decreaseSize();
        }
        if (rectangle != null) {
            rectangle.decreaseSize();
        }
        drawPanel.repaint();
    }

    public void increaseSizeCircles() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Circle){
                TFigure circle = massive[i];
                circle.increaseSize();
            }
        }
        drawPanel.repaint();
    }

    public void flip() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Ellipse) {
                Ellipse ellipse = (Ellipse) massive[i];
                ellipse.flip();
            }
        }
        drawPanel.repaint();
    }

    public void decreaseSizeCircles() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Circle){
                TFigure circle = massive[i];
                circle.decreaseSize();
            }
        }
        drawPanel.repaint();
    }

    public void increaseSizeSquares() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Square){
                TFigure square = massive[i];
                square.increaseSize();
            }
        }
        drawPanel.repaint();
    }

    public void decreaseSizeSquares() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Square){
                TFigure square = massive[i];
                square.decreaseSize();
            }
        }
        drawPanel.repaint();
    }

    public void increaseSizeTriangles() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Triangle) {
                TFigure triangle = massive[i];
                triangle.increaseSize();
            }
        }
        drawPanel.repaint();
    }

    public void decreaseSizeTriangles() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Triangle) {
                TFigure triangle = massive[i];
                triangle.decreaseSize();
            }
        }
        drawPanel.repaint();
    }

    public void moveCirclesDown() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Circle) {
                massive[i].MoveTo(10, 20, g2D);
            }
        }
        drawPanel.repaint();
    }

    public void moveRectanglesDown() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Rectangle) {
                massive[i].MoveTo(10, 20, g2D);
            }
        }
        drawPanel.repaint();
    }

    public void moveSquaresDown() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Square) {
                massive[i].MoveTo(10, 20, g2D);
            }
        }
        drawPanel.repaint();
    }


    public void moveTrianglesDown() {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] instanceof Triangle) {
                massive[i].MoveTo(10, 20, g2D);
            }
        }
        drawPanel.repaint();
    }

    public void removeArrayOfSquares() {
        squares = new Square[0];
        squaresArray = false;
        drawPanel.repaint();
    }

    public void removeArrayOfCircles() {
        circles = new Circle[0];
        circlesArray = false;
        drawPanel.repaint();
    }

    public void removeArrayOfTriangles() {
        triangles = new Triangle[0];
        trianglesArray = false;
        drawPanel.repaint();
    }

    public void clearCanvas() {
        squares = new Square[0];
        triangles = new Triangle[0];
        circles = new Circle[0];
        ellipses = new Ellipse[0];
        rectangles = new Rectangle[0];
        pentagons = new Pentagon[0];
        shapesArray = false;
        pentagon = null;
        square = null;
        triangle = null;
        circle = null;
        ellipse = null;
        rectangle = null;
        drawPanel.repaint();
    }

    public void Show(Class<?> shapeClass) {
        for (Square square : squares) {
            if (shapeClass.isInstance(square)) {
                square.Show();
            }
        }
        for (Triangle triangle : triangles) {
            if (shapeClass.isInstance(triangle)) {
                triangle.Show();
            }
        }
        for (Circle circle : circles) {
            if (shapeClass.isInstance(circle)) {
                circle.Show();
            }
        }
        for (Pentagon pentagon : pentagons) {
            if (shapeClass.isInstance(pentagon)) {
                pentagon.Show();
            }
        }
        for (Rectangle rectangle : rectangles) {
            if (shapeClass.isInstance(rectangle)) {
                rectangle.Show();
            }
        }
        for (Ellipse ellipse : ellipses) {
            if (shapeClass.isInstance(ellipse)) {
                ellipse.Show();
            }
        }
        drawPanel.repaint();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShapePaint::new);
    }
}