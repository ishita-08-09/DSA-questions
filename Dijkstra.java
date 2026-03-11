import java.util.*;
public class Dijkstra {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n2=sc.nextInt();
        int m=sc.nextInt();
        int n = n2+1;
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<int[]> row=new ArrayList<>();
            adj.add(row);
        }

        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});


        }
        int[] p=dijkstra(n,adj);
        ArrayList<Integer> answer=new ArrayList<>();
        int node=n-1;
        while(node!=1){
            answer.add(node);
            node=p[node];


        }
        answer.add(1);
        System.out.println( answer);

    }
    static int[] dijkstra(int n,ArrayList<ArrayList<int[]>> adj){
    boolean[] finalised=new boolean[n];
    int[] dis=new int[n];
    Arrays.fill(dis,Integer.MAX_VALUE);
    dis[0]=0;
    PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[1]-b[1]);
    q.add(new int[]{1,0});
    int[] parent=new int[n];
    parent[0]=-1;
    parent[1]=1;
    while(!q.isEmpty()){
        int[] p=q.poll();
        int f=p[0];
        int g=p[1];
        if(!finalised[f]){
            finalised[f]=true;
            for(int[] j:adj.get(f)){
                int v=j[0];
                int w=j[1];
                if(!finalised[v]) relax(f,g,w,v,dis,q,parent);
            }
        }
    }
    return parent;
}
static void relax(int f,int g,int w,int v,int[] dis,PriorityQueue<int[]> q,int[] parent){
    if((g+w)<dis[v]){
        dis[v]=g+w;
        parent[v]=f;
        q.add(new int[] {v,dis[v]});
    }
}

}
