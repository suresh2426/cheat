import java.util.*;

class Rhombus {
    public double d1, d2;

    public Rhombus(double diagonal1, double diagonal2) {
        d1 = diagonal1;
        d2 = diagonal2;
    }

    public double area() {
        return (d1 * d2) / 2;
    }
}

public class MyRhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of diagonal 1: ");
        double diagonal1 = scanner.nextDouble();

        System.out.print("Enter the length of diagonal 2: ");
        double diagonal2 = scanner.nextDouble();

        Rhombus aRhombus = new Rhombus(diagonal1, diagonal2);
        double area = aRhombus.area();

        System.out.println("Diagonal 1: " + aRhombus.d1 + ", Diagonal 2: " + aRhombus.d2 + ", Area: " + area);

        scanner.close();
    }
}
