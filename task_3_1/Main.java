public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Rectangle("Red", 10, 5),
            new Circle("Blue", 3),
            new Triangle("Green", 4, 6),
            new Circle("Yellow", 2.5),
            new Rectangle("Black", 2, 8),
            new Triangle("White", 5, 5),
            new Circle("Red", 4.2),
            new Rectangle("Green", 7, 3),
            new Triangle("Blue", 10, 2),
            new Circle("Purple", 1.5)
        };

        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);
        
        controller.run();
    }
}