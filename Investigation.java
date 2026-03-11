import java.io.*;
import java.util.*;
public class Investigation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] finalised=new int[n+1];
        long[] dis=new long[n+1];
        int[] ways=new int[n+1];
        int[] max=new int[n+1];
        int[] min=new int[n+1];
        ways[1]=1;

        Arrays.fill(dis,Long.MAX_VALUE);
        ArrayList<ArrayList<long[]>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            ArrayList<long[]> row=new ArrayList<>();
            adj.add(row);
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            long w=Integer.parseInt(st.nextToken());
            adj.get(u).add(new long[]{v,w});

        }
        PriorityQueue<long[]> q=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        dis[1]=0;
        q.add(new long[]{1,0});
        while(!q.isEmpty()){
            long[] p=q.poll();
            int f=(int)p[0];
            long g=p[1];
            if(finalised[f]==0){
                finalised[f]=1;
                for(long[] j:adj.get(f)){
                        int v=(int) j[0];
                        long w=j[1];
                        if(finalised[v]==0) {
                            relax(f,g,v,w,dis,min,max,ways,q);
                        }

                }
            }
        }
        System.out.println(dis[n]+" "+ ways[n]% ((int)1e9+7)+" "+ min[n]+" "+max[n]);


    }
    static void relax(int f,long g,int v,long w,long[] dis,int[] min,int[] max,int[] ways,PriorityQueue<long[]> q){
        if(g+w<dis[v]){
            dis[v]=g+w;
            ways[v]=ways[f]% ((int)1e9+7);
            min[v]=min[f]+1;
            max[v]=max[f]+1;
            q.add(new long[]{v,dis[v]});
        }
        else if(g+w==dis[v]){
            ways[v]=(ways[v]% ((int)1e9+7)+ways[f]% ((int)1e9+7))% ((int)1e9+7);
            min[v]=Math.min(min[v],min[f]+1);
            max[v]=Math.max(max[v],max[f]+1);

        }
    }
}