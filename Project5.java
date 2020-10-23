package learning;

public class Project5 {
    public static void main(String[] args) {

        BigInt a = new BigInt(args.length == 2 ? args[0] : "9999");

        BigInt b = new BigInt(args.length == 2 ? args[1] : "1999");

        System.out.println(a + (a.equals(b) ? " equals " : " does not equal ") + b);

        System.out.println(a + (a.compareTo(b) < 0 ? " < " : (a.compareTo(b) > 0 ? " > " : " = ")) + b);

        System.out.println(a + " + " + b + " = " + a.add(b));
        if (a.compareTo(b) >= 0) {
            System.out.println(a + " - " + b + " = " + a.sub(b));
        }
        System.out.println(a + " * " + b + " = " + a.mul(b));
        if (a.compareTo(b) >= 0) {
            System.out.println(a + " / " + b + " = " + a.div(b));
        }
    }
}

final class BigInt implements Comparable<BigInt> {

    public BigInt() {

        n = new int[1];
    }

    public BigInt(String s) {

        n = new int[s.length()];

        for (int i = 0; i < n.length; ++i) {
            n[n.length - i - 1] = s.charAt(i) - '0';
        }

        n = trim(n);
    }

    private BigInt(int[] n) {

        this.n = new int[n.length];

        for (int i = 0; i < n.length; ++i) {
            this.n[i] = n[i];
        }
    }

    public BigInt add(BigInt o) {

        int carry = 0;
        int max = n.length > o.n.length ? n.length : o.n.length;
        int[] result = new int[max+1];

        for (int i = 0; i <= max; ++i) {

            int top = i < n.length ? n[i] : 0;
            int bot = i < o.n.length ? o.n[i] : 0;

            result[i] = (top + bot + carry) % 10;
            carry = (top + bot + carry) / 10;
        }

        return new BigInt(trim(result));
    }

    public int compareTo(BigInt o) {

        int length1 = n.length;
        int length2 = o.n.length;
        if(length1 > length2){
            return 1;
        }
        else if(length2> length1){
            return -1;
        }
        else {
            for(int i=length1-1; i>=0; i--){
                if(n[i] > o.n[i]){
                    return 1;
                }else if(n[i] < o.n[i]){
                    return -1;
                }
            }
            return 0;
        }
    }
    public BigInt div(BigInt o) {

        return null;
    }

    public boolean equals(BigInt o) {

        int length1 = n.length;
        int length2 = o.n.length;
        if(length1 != length2){
            return false;
        }
        else{
            for(int i=length1-1; i>=0; i--){
                if(n[i] != o.n[i]){
                    return false;
                }
            }
            return true;
        }
    }

    public BigInt mul(BigInt o) {

        int length1 = n.length;
        int length2 = o.n.length;
        if(length1 == 0 || length2 ==0){
            return new BigInt("0");
        }


        int result[] = new int[length1+length2];
        for(int i=0; i<result.length; i++){
            result[i] = 0;
        }

        int carry = 0;
        int product =0;
        int sum = 0;

        int current = 0;
        for(int i=0; i<length1; i++){
            current = i;
            carry = 0;
            for(int j=0; j<length2;j++){
                product = n[i] * o.n[j];
                sum = carry + product + result[current];
                result[current] = sum %10;
                carry = sum /10;
                current++;

            }

            if(carry >0){
                result[current] = carry;
            }
        }

        return new BigInt(result);
    }
    public BigInt sub(BigInt o) {
        int length1 = n.length;
        int length2 = o.n.length;
        int[] result = new int[length1];
        //result.n = n;
        int k=0;
        int carry = 0;

        for(int i=0; i<length2;i++){
            int sub = (n[i] - o.n[i] - carry);
            if(sub < 0){
                sub = sub +10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            result[k++] = sub;
        }

        for (int i=length2; i<length1; i++){
            int sub = n[i] - carry;
            if (sub <0) {
                sub = sub +10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            result[k++] = sub;
        }

        return new BigInt(result);
    }

    public String toString() {

        String s = "";

        for (int i : n) {
            s = i + s;
        }

        return s;
    }

    private int[] trim(int[] nums) {

        int size = nums.length;

        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] != 0) {
                break;
            }
            --size;
        }

        int[] res = new int[size];

        for (int i = 0; i < size; ++i) {
            res[i] = nums[i];
        }

        return res;
    }

    private int[] n;
}