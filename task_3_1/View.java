import java.util.Arrays;
import java.util.Comparator;

class ShapeView {
    public void printMessage(String message) {
        System.out.println("\n--- " + message + " ---");
    }

    public void printShapes(Shape[] shapes) {
        for (Shape s : shapes) s.draw();
    }

    public void printTotalArea(double area) {
        System.out.printf("Total Area: %.2f\n", area);
    }
}

class ShapeController {
    private Shape[] model;
    private ShapeView view;

    public ShapeController(Shape[] model, ShapeView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.printMessage("Initial Data Set");
        view.printShapes(model);

        view.printMessage("Total Area of all shapes");
        view.printTotalArea(calculateTotalArea(model));

        view.printMessage("Total Area of Circles");
        view.printTotalArea(calculateTotalAreaByType(Circle.class));

        view.printMessage("Sorting by Area (Ascending)");
        Arrays.sort(model, Comparator.comparingDouble(Shape::calcArea));
        view.printShapes(model);

        view.printMessage("Sorting by Color");
        Arrays.sort(model, Comparator.comparing(Shape::getShapeColor));
        view.printShapes(model);
    }

    private double calculateTotalArea(Shape[] shapes) {
        double sum = 0;
        for (Shape s : shapes) sum += s.calcArea();
        return sum;
    }

    private double calculateTotalAreaByType(Class<? extends Shape> type) {
        double sum = 0;
        for (Shape s : model) {
            if (type.isInstance(s)) sum += s.calcArea();
        }
        return sum;
    }
}