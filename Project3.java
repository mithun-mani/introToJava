import java.util.ArrayList;
public class Project3 {
    public static void main(String[] args) {
        int arr [] = new int[100];
        sieve(arr);
        goldbach(arr);
    }
    public static ArrayList<Integer> primeList= new ArrayList<Integer>();
    public static void sieve (int [] array){
        for (int i = 0; i < array.length; i++){
            array[i] = i+1;
        }
        for (int i = 2; i*i <= array.length; i++){
            if (array[i] != 0){
                for (int j = i*i; j <= array.length - 1; j += i){
                    array[j] = 0;
                }
            }
        }
        for (int i = 2; i <= array.length - 1; i++){
            if(array[i] != 0){
                System.out.println(i);
                primeList.add(i);
            }
        }
    }
    public static void goldbach (int [] array){
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        for (int i = 0; i <= array.length; i+=2){
            evenList.add(i);
        }
        for (int i: evenList){
            for(int j:primeList){
                if(primeList.contains(i-j)){
                    System.out.println(i + " = " + j + " + " + (i-j));
                    break;
                }
            }
        }
    }
}