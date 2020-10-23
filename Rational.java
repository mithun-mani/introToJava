public class Rational extends Number implements Comparable<Rational>{

    private int num;
    private int denom;

    public Rational(int num, int denom){
        this.num = num;
        this.denom = denom;
    }

    public int intValue(){
        return num/denom;
    }

    public long longValue(){
        return (long) num/ (long) denom;
    }

    public float floatValue(){
        return (float)num/(float)denom;
    }

    public double doubleValue(){
        return (double)num/(double)denom;
    }

    public int compareTo(Rational T){
        if (this.doubleValue() > T.doubleValue()){
            return 1;
        }
        else if (this.doubleValue() == T.doubleValue()){
            return 0;
        }
        else {
            return -1;
        }

    }


    public Rational add(Rational o){
        int numerator = (this.num * o.denom + this.denom * o.num);
        int denominator = (this.denom * o.denom);
        Rational newRat = new Rational(numerator, denominator);
        newRat.gcd();
        return newRat;
    }

    public Rational sub(Rational o){
        int numerator = (this.num * o.denom - this.denom*o.num);
        int denominator = (this.denom * o.denom);
        Rational newRat = new Rational(numerator, denominator);
        newRat.gcd();
        return newRat;
    }

    public Rational mul (Rational o){
        Rational newRat = new Rational(this.num*o.num, this.denom*o.denom);
        newRat.gcd();
        return newRat;
    }

    public Rational reciprocal (){
        return new Rational(this.denom, this.num);
    }

    public Rational div (Rational o){
        return this.mul(o.reciprocal());
    }

    private void gcd (){
        int n = num;
        int d = denom;
        int remainder = 1;
        while (remainder != 0){
            remainder = n % d;
            n = d;
            d = remainder;
        }
        this.num/=n;
        this.denom/= n;
    }

    public String toString(){
        return ("The number is " + num + "/" + denom);
    }
}