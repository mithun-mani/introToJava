import java.util.*;
public class Homework4 {
    public static void main(String[] args) {
        /*
        Multiple Choice
        1.) B
        2.) A
        3.) B
        4.) D
        5.) D
        6.) B
        7.) A
        8.) A
        9.) D
        10.) B
         */
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter a radius: ");
        int rad = sc.nextInt();
        Circle2 c1 = new Circle2(rad);
        Circle2 c2 = new Circle2((r.nextInt(10)+5));
        System.out.println("c1: " + c1.area() + " c2: " + c2.area());
        int r1= c1.getRadius();
        int r2 = c2.getRadius();
        c1.setRadius(r2);
        c2.setRadius(r1);
        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println("Enter string 1: ");
        String s1 = sc.next();
        System.out.println("Enter string 2: ");
        String s2 = sc.next();
        System.out.println(((s1.length()+s2.length())/2.0));
        if (s1.length() == s2.length()){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
        char char1 = s1.charAt(r.nextInt(s1.length()));
        char char2 = s2.charAt(r.nextInt(s2.length()));
        System.out.println(char1 + "," + char2);
    }
}

class Circle2{
    private int radius;
    public Circle2(int r){
        radius = r;
    }
    public Circle2(){
        radius = 5;
    }
    public int getRadius(){
        return radius;
    }
    public void setRadius(int r){
        radius = r;
    }
    public String toString(){
        return "The circle has radius of " + radius;
    }
    public double area(){
        return (Math.PI*Math.pow(radius,2));
    }
}
