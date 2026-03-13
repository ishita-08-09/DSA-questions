import java.util.*;
public class Ice_Skating {
    public static void main(String[] args) {
        int ans=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xx = new int[n];
        int[] yy = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            xx[i] = x;
            yy[i] = y;
        }
        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                ans++;

                dfs(n,i,visited,xx,yy);

            }
        }
        System.out.println(ans-1);



    }
    static void dfs(int n,int i,int[] visited,int[]xx,int[] yy){
        visited[i]=1;
        for(int j=0;j<n;j++){
            if (visited[j]==0 && j!=i){
                if(xx[i]==xx[j] || yy[i]==yy[j]){
                    dfs(n,j,visited,xx,yy);
                }

            }

        }
    }

}
