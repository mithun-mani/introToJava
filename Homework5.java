import java.util.ArrayList;
import java.util.Arrays;

public class Homework5 {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1,23,44,5,6,4,534,753,45,34,7,8,56,876));
        System.out.println(mean(ints));
        System.out.println(standardDev(ints));

    }
    public static double mean(ArrayList<Integer> ints){
        int sum = 0;
        for (int n : ints){
            sum += n;
        }
        return (double)sum/(double)ints.size();
    }

    public static double standardDev(ArrayList<Integer> ints){
        double sum = 0;
        double mean = mean(ints);
        for (int n: ints){
            sum += Math.pow((float)(n-mean), 2);

        }
        return Math.sqrt(sum/ints.size());
    }




}
