public class Pascal {
    public static int [] triangle (int n){
        int [] output = new int[n];
        if (n == 1){
            output[0] = 1;
            return output;
        }
        if (n == 2){
            output[0] = 1;
            output[1] = 1;
            return output;
        }
        output[0] = 1;
        output[n-1] = 1;
        for (int i = 1; i < output.length - 1;i++){
            output[i] = triangle(n-1)[i-1] + triangle(n-1)[i];
        }
        return output;
    }
}
