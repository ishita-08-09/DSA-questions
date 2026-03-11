import java.util.*;
public class Cycle_finding {
    public static void main(String[] args){
        boolean value=false;
        int p=0;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[][] edges=new int[m][3];
        for(int i=0;i<m;i++){
            int[] e=new int[3];
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            e[0]=u;
            e[1]=v;
            e[2]=w;
            edges[i]=e;
        }
        int[] parent=new int[n+1];
        int[] dis=new int[n+1];
        for(int i=0;i<n;i++){
            for(int[] edge:edges){
                 int u=edge[0];
                 int v=edge[1];
                 int w=edge[2];
                 relax(u,v,w,dis,parent);
            }
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            value=relax(u,v,w,dis,parent);
            if (!value){
                continue;

            }
            else if(value==true){
                p=v;
                System.out.println("YES");
                break;
            }

        }
        if(!value) {
            System.out.println("NO");
        }

        if(value){
        ArrayList<Integer> a=new ArrayList<>();
        int k=0;
        while(k<n){
//            a.add(parent[p]);
            p=parent[p];
            k++;
        }
//        int c=a.get(a.size()-1);
        ArrayList<Integer> ans=new ArrayList<>();
//        int start=a.get(a.size()-1);
//        ans.add(start);
//        int node=parent[start];

        int start= p;
        while(ans.size()==0 || p!=start){
            ans.add(p);
            p=parent[p];
        }
        ans.add(start);

        System.out.println(ans);}

    }
        static boolean relax(int u,int v,int w,int[] dis,int[] parent){
             if(dis[u]+w<dis[v]){
                 dis[v]=dis[u]+w;
                 parent[v]=u;
                 return true;


             }
             return false;

        }
}
