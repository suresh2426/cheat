import java.util.*;

class Circle {
    public double x, y;
    public double r;

    Circle(double centreX, double centreY, double radius) {
        x = centreX;
        y = centreY;
        r = radius;
    }

    double circumference() {
        return 2 * Math.PI * r; 
    }

    double area() {
        return Math.PI * r * r; 
    }
}

public class MyCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the center X coordinate: ");
        double centreX = scanner.nextDouble();
        
        System.out.print("Enter the center Y coordinate: ");
        double centreY = scanner.nextDouble();
        
        System.out.print("Enter the radius: ");
        double radius = scanner.nextDouble();
        

        Circle aCircle = new Circle(centreX, centreY, radius);

        double area = aCircle.area();
        double circumf = aCircle.circumference();

        System.out.println("Radius: " + aCircle.r + ", Area: " + area);
        System.out.println("Radius: " + aCircle.r + ", Circumference: " + circumf);
        
        scanner.close();
    }
}
                                           