public class PowXN{
    public double myPow(double x, int n) {
        return power(x,n);
    }

    double power(double x,long n){
        if(n==0) return 1;

        if(n<0) return 1/power(x,-n);

        double half = power(x,n/2);

        if(n%2==0)
            return half*half;
        else
            return x*half*half;
    }
}