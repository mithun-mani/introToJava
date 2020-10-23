import java.util.Scanner;

public class Homework1 {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter inches: ");
        int inches = sc.nextInt();
        double i = inches;
        double feet = i/12;
        System.out.println("This is " + feet + " feet");


        System.out.println("Enter grams: ");
        float grams = sc.nextFloat();
        double pounds = grams/453.592;
        System.out.println("This is " + pounds + " pounds");

        System.out.println("Enter kilograms: ");
        int kg = sc.nextInt();
        System.out.println("Enter grams: ");
        int g = sc.nextInt();
        System.out.println("Enter milligrams: ");
        int mg = sc.nextInt();
        int milli = kg*1000000 + g*1000 + mg;
        System.out.println(milli + " milligrams");

        System.out.println("Enter milligrams: ");
        milli = sc.nextInt();
        kg = milli / 1000000;
        g = (milli - kg*1000000)/1000;
        mg = (milli - kg*1000000) - g*1000;
        System.out.println(kg + " kilograms " + g + " grams " + mg + " milligrams ");
    }
}
