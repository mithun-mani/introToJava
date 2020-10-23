import java.lang.*;
import java.text.DecimalFormat;
import java.util.*;

public class Homework2 {

    public static void main(String[] args) {

        Circle c1 = new Circle(10);
        System.out.println(c1);
        c1.setRadius(3);
        System.out.println(c1);

        Circle c2 = new Circle(43);
        System.out.println(c2);
        c1.setRadius(23);
        System.out.println(c2);

        Shelf s1 = new Shelf(10, 15, 15);
        Shelf s2 = new Shelf(15,20,35);

        System.out.println(s1);
        System.out.println(s2);

        s1.setOccupied(true);
        s1.setCapacity(20);

        s2.setBreadth(43);
        s2.setLength(65);

        System.out.println(s1);
        System.out.println(s2);

    }

    private static double slope(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    private static void sphere(double radius) {
        double volume = (4 / 3) * (Math.PI) * Math.pow(radius, 3);
        double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);

        DecimalFormat fmt = new DecimalFormat("0.####");
        System.out.println("The circle's volume" + fmt.format(volume));
        System.out.println("The circle's surfaceArea" + fmt.format(surfaceArea));
    }

    private static void trapezoid(double s1, double s2, double height) {
        DecimalFormat fmt = new DecimalFormat("0.####");
        double area = (s1 + s2) / 2 * height;
        System.out.println("The area is" + fmt.format(height));
    }

    private static void parallelogram() {
        Random rand = new Random();
        double b = rand.nextInt(20) + 10;
        double h = rand.nextInt(20) + 10;
        double a = rand.nextInt(20) + 10;
        System.out.println("The area is " + b * h);
        System.out.println("The perimeter is " + 2 * (a + b));
    }
}

    class Circle {

        private double radius;

        public Circle(double radius){
            this.radius = radius;
        }

        public double getRadius(){
            return this.radius;
        }

        public void setRadius(double value){
            this.radius = value;
        }

        public double circumference(){
            return (2*Math.PI*this.radius);
        }

        public double area(){
            return (Math.PI*(Math.pow(this.radius,2)));
        }

        public String toString(){
            return ("The circle has a radius of " + radius + " with circumference " + this.circumference() + " and an area of " + this.area() + ".");
        }
    }


    class Shelf{

        private double length, breadth;
        private int capacity;
        private boolean occupied;

        public Shelf (double length, double breadth, int capacity){
            occupied = false;
            this.length = length;
            this.breadth = breadth;
            this.capacity = capacity;
        }

        public double getLength(){
            return this.length;
        }

        public double getBreadth(){
            return this.breadth;
        }

        public int getCapacity(){
            return this.capacity;
        }

        public void setLength(double newLength){
            this.length = newLength;
        }

        public void setBreadth(double newBreadth){
            this.breadth = newBreadth;
        }

        public void setCapacity(int newCapacity){
            this.capacity = newCapacity;
        }

        public void setOccupied(boolean newOccupied){
            this.occupied = newOccupied;
        }

        public boolean getOccupied(){
            return this.occupied;
        }

        public String toString(){
            return ("Length: " + length + " Breadth: "  + breadth + " Capacity: " + capacity + " Occupancy: " + occupied);
        }

    }


