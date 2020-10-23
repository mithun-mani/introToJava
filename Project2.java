import java.util.Random;

public class Project2 {

    public static void main(String[] args) {
        System.out.println(4*ratio());
        System.out.println(4*experiment(10000000));
    }

    public static double ratio(){
        double squareArea = 1;
        double radius = 0.5;
        double circleArea = Math.PI * Math.pow(radius, 2);
        return circleArea/squareArea;
    }

    public static double distance(double x1, double y1){
        return Math.pow(Math.pow((0.5 - x1), 2) + Math.pow((0.5 - y1), 2),0.5);
    }

    public static double experiment(int numberOfTimes){
        Random rand = new Random();
        double circleCount = 0;
        double count = 0;

        for (int i = 0; i < numberOfTimes; i++){
            if (distance(rand.nextDouble(), rand.nextDouble()) < 0.5){
                circleCount++;
                count++;
            }
            else {
                count++;
            }
        }
        return circleCount/count;

    }


}
