import java.util.*;
public class Kefa_and_park {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int ans=0;
        int is_consecutive=0;
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] l=new int[n+1];
        l[0]=0;
        for(int i=1;i<=n;i++){
            l[i]=sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            ArrayList<Integer> edge=new ArrayList<>();
            edge.add(u);
            edge.add(v);
            edges.add(edge);


        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> row=new ArrayList<>();
            adj.add(row);
        }
        int index=0;
        for(ArrayList<Integer> edge:edges){
            int u=edge.get(0);
            int v=edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);


        }
        int node=1;
        int finall=dfs(node,l,m,is_consecutive,adj,ans);
        System.out.println(finall);
    }

    static int dfs(int node,int[] l,int m,int is_consecutive,ArrayList<ArrayList<Integer>> adj,int ans) {
        boolean is_leaf=true;
        if(l[node-1]==1){
            is_consecutive=is_consecutive+1;
            if(is_consecutive>m){}

            for(int j:adj.get(node-1)){
                is_leaf=false;
                dfs(j,l,m,is_consecutive,adj,ans);
            }
            if(is_leaf){
                ans++;
            }
        }
        else{
            is_consecutive=0;
            for(int j:adj.get(node-1)){
                is_leaf=false;
                dfs(j,l,m,is_consecutive,adj,ans);
            }
            if(is_leaf){
                ans++;
            }
        }
        return ans;


    }



}

