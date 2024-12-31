import java.util.*;

interface Shape {
    double surfaceArea();
    double volume();
}

class Sphere implements Shape {
    private double r;
    private static final double PI = 3.1415926535;

    Sphere(double radius) {
        this.r = radius;
    }

    public double surfaceArea() {
        return 4 * PI * r * r;
    }

    public double volume() {
        return (4.0 / 3) * PI * r * r * r; 
    }
}

class Cube implements Shape {
    private double a;

    Cube(double side) {
        this.a = side;
    }

    public double surfaceArea() {
        return 6 * a * a;
    }

    public double volume() {
        return a * a * a;
    }
}

class RectangularPrism implements Shape {
    private double a, b, c;

    RectangularPrism(double length, double breadth, double height) {
        this.a = length;
        this.b = breadth;
        this.c = height;
    }

    public double surfaceArea() {
        return 2 * ((a * b) + (b * c) + (a * c));
    }

    public double volume() {
        return a * b * c;
    }
}

class Cylinder implements Shape {
    private double r, h;
    private static final double PI = 3.1415926535;

    Cylinder(double radius, double height) {
        this.r = radius;
        this.h = height;
    }

    public double surfaceArea() {
        return 2 * PI * r * (h + r);
    }

    public double volume() {
        return PI * r * r * h;
    }
}

public class InterfacePrg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius for Sphere: ");
        double sphereRadius = scanner.nextDouble();
        Shape sphere = new Sphere(sphereRadius);
        System.out.println("Surface Area of Sphere: " + sphere.surfaceArea());
        System.out.println("Volume of Sphere: " + sphere.volume());

        System.out.print("Enter side length of the cube: ");
        double cubeSide = scanner.nextDouble();
        Shape cube = new Cube(cubeSide);
        System.out.println("Surface Area of Cube: " + cube.surfaceArea());
        System.out.println("Volume of Cube: " + cube.volume());

        System.out.print("Enter length of the box: ");
        double length = scanner.nextDouble();
        System.out.print("Enter breadth of the box: ");
        double breadth = scanner.nextDouble();
        System.out.print("Enter height of the box: ");
        double height = scanner.nextDouble();
        Shape rectangularPrism = new RectangularPrism(length, breadth, height);
        System.out.println("Surface Area of Rectangular Prism: " + rectangularPrism.surfaceArea());
        System.out.println("Volume of Rectangular Prism: " + rectangularPrism.volume());

        System.out.print("Enter radius of cylinder: ");
        double cldRadius = scanner.nextDouble();
        System.out.print("Enter height of cylinder: ");
        double cldHeight = scanner.nextDouble();
        Shape cylinder = new Cylinder(cldRadius, cldHeight);
        System.out.println("Surface Area of Right Circular Cylinder: " + cylinder.surfaceArea());
        System.out.println("Volume of Right Circular Cylinder: " + cylinder.volume());
    }
}