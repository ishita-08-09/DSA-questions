import java.util.*;
public class FlightRouteCheck {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            ArrayList<Integer> row1=new ArrayList<>();
            ArrayList<Integer> row2=new ArrayList<>();
            adj.add(row1);
            adjj.add(row2);
        }

        int[] vis1=new int[n+1];
        int[] vis2=new int[n+1];
        boolean is_not_path=false;
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adjj.get(v).add(u);
         }
        dfs(1,vis1,adj);
        dfs(1,vis2,adjj);
        for(int i=1;i<n+1;i++){
            if(vis1[i]==0){
                System.out.println("NO");
                System.out.println("1"+" " +i);
                is_not_path=true;
                break;

            }


        }
        if(!is_not_path){
            for(int i=1;i<n+1;i++){
                if(vis2[i]==0){
                    System.out.println("NO");
                    System.out.println(i+" "+ "1");
                    break;
                }
                else{
                    ans.add(i);
                }
            }
        }
        if(ans.size()==n){
            System.out.println("YES");
        }
}
static void dfs(int i,int[] vis,ArrayList<ArrayList<Integer>> adj){
      vis[i]  =1;
      for(int j:adj.get(i)){
          if(vis[j]==0){
              dfs(j,vis,adj);
          }

      }
}
}
