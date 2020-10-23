public class Homework6 {
    public static void main(String[] args) {
        Cube c1 = new Cube(15);
        System.out.println(c1.getInfo());
        Sphere s1 = new Sphere(23);
        System.out.println(s1.getInfo());
    }
}

abstract class Shape3d{
    public abstract double volume();
    public abstract double area();
    public abstract String getInfo();
}

class Cube extends Shape3d{
    private double length;

    public Cube(double l){
        length = l;
    }

    public void setLength(double l){
        length = l;
    }

    public double volume(){
        return (Math.pow(length,3));
    }
    public double area(){
        return (6*Math.pow(length,2));
    }
    public String getInfo(){
        return ("Volume: " + this.volume() + " Area: " + this.area()) + " Length: " + length;
    }
}

class Sphere extends Shape3d{
    private double radius;

    public Sphere(double r){
        radius = r;
    }

    public void setRadius(double r){
        radius = r;
    }

    public double volume(){
        return (4/3 * Math.PI*Math.pow(radius,3));
    }

    public double area(){
        return (4 * Math.PI*Math.pow(radius,2));
    }
    public double circumference(){
        return (2 * Math.PI*radius);
    }
    public String getInfo(){
        return ("Volume: " + this.volume() + " Area: " + this.area() + " Circumference: " + this.circumference() + " radius: " + radius);
    }

}