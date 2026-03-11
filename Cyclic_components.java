import java.util.*;
public class Cyclic_components {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] vis=new int[n+1];
        int[] curr_path=new int[n+1];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            ArrayList<Integer> row=new ArrayList<>();
            adj.add(row);
        }
        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count=0;
        int ans=0;
        for(int i=0;i<n+1;i++){
            if(vis[i]==0){
                boolean is_false=false;
                ArrayList<Integer> component=new ArrayList<>();
                ArrayList<Integer> answer=new ArrayList<>();
                answer=dfs(curr_path,i,vis,adj,count,component);
                for(int k:answer){
                    if(adj.get(k).size()!=2){
                        is_false=true;
                    }
                }
                if(!is_false){
                    ans++;
                }


            }
        }
        System.out.println(ans);

    }
    static ArrayList<Integer> dfs(int[] curr_path,int i,int[] vis,ArrayList<ArrayList<Integer>> adj,int count,ArrayList<Integer> component){
        vis[i]=1;
        curr_path[i]=1;
        component.add(i);
        for(int j:adj.get(i)){
            if(vis[j]==0){
                dfs(curr_path,j,vis,adj,count,component);
            }


        }

       return component;


    }
}
