  import java.util.*;

abstract class Shape{
abstract double surfaceArea();
abstract double volume();
}


class sphere extends Shape{
double r;
private static final double PI = 3.1415926535;

sphere(double radius) {
this.r = radius;
}

double surfaceArea(){
return 4*PI*r*r;
}

double volume (){
return (4/3) * PI * r * r * r;
}
}


class cube extends Shape{
double a;

cube(double side){
this.a = side;
}

double surfaceArea(){
return 6*a*a;
}

double volume(){
return a*a*a;
}
}


class rectangularPrism extends Shape{
double a, b, c;

rectangularPrism(double length, double breadth, double height){
this.a = length;
this.b = breadth;
this.c = height;
}

double surfaceArea(){
return 2 * ((a*b) + (b*c) + (a*c));
}

double volume(){
return a*b*c;
}
}

class cylinder extends Shape{
private static final double PI = 3.1415926535;
double r, h;

cylinder(double radius, double height){
this.r = radius;
this.h = height;
}

double surfaceArea(){
return 2 * PI * r * (h + r);
}

double volume(){
return PI * r * r * h;
}
}

public class AbstractPrg{
public static void main(String args[]){
Scanner scanner = new Scanner(System.in);

System.out.print("Enter radius for Sphere: ");
double sphereRadius = scanner.nextDouble();
sphere sp = new sphere(sphereRadius);
System.out.println("Surface Area of Sphere: " +sp.surfaceArea());
System.out.println("Volume of Sphere: " +sp.volume());

System.out.print("Enter side length of the cube: ");
double cubeSide = scanner.nextDouble();
cube cb = new cube(cubeSide);
System.out.println("Surface Area of Cube: " +cb.surfaceArea());
System.out.println("Volume of Cube: " +cb.volume());

System.out.print("Enter length of the box: ");
double length = scanner.nextDouble();
System.out.print("Enter breadth of the box: ");
double breadth = scanner.nextDouble();
System.out.print("Enter height of the box: ");
double height = scanner.nextDouble();
rectangularPrism rect = new rectangularPrism(length, breadth, height);
System.out.println("Surface Area of Rectangular Prism: " +rect.surfaceArea());
System.out.println("Volume of Rectangular Prism: " +rect.volume());

System.out.print("Enter radius of cylinder: ");
double cldRadius = scanner.nextDouble();
System.out.print("Enter height of cylinder: ");
double cldHeight = scanner.nextDouble();
cylinder cld = new cylinder(cldRadius, cldHeight);
System.out.println("Surface Area of Right Circular Cylinder: " + cld.surfaceArea());
System.out.println("Volume of Right Circular Cylinder: " +cld.volume());
}
}