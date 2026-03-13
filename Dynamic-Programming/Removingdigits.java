import java.util.*;
import java.lang.*;
import java.io.*;
public class Removingdigits {
    public static void main(String[] args) throws IOException{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=new StringTokenizer(br.readLine());
       int n=Integer.parseInt(st.nextToken());
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       int ans=helper(n,dp);
       System.out.println(ans);
    }
    static int helper(int n,int[] dp){
        int res=Integer.MAX_VALUE;
        ArrayList<Integer> arrr=func(n);
        if(arrr.size()==1) return 1;
        if (dp[n]!=-1) return dp[n];
        for(int i=0;i<arrr.size();i++){
            if(arrr.get(i)==0) continue;
            else{
                res=Math.min(res,1+helper(n-arrr.get(i),dp));
            }

        }
        return dp[n]=res;
    }
   static  ArrayList<Integer> func(int n){

        ArrayList<Integer> arr=new ArrayList<>();
        while(n!=0){
            int s=n%10;
            n=n/10;
            arr.add(s);

        }
        return arr;
    }
}

