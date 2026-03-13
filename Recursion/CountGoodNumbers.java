public class CountGoodNumbers {

    long mod = 1000000007;

    public int countGoodNumbers(long n) {

        long even = power(5,(n+1)/2);
        long odd = power(4,n/2);

        return (int)((even*odd)%mod);
    }

    long power(long x,long n){

        if(n==0) return 1;

        long half = power(x,n/2)%mod;

        if(n%2==0)
            return (half*half)%mod;

        return (x*half*half)%mod;
    }
}