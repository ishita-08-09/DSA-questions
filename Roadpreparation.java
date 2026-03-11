import java.io.*;
import java.util.*;
public class Roadpreparation {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            ArrayList<int[]> row=new ArrayList<>();
            adj.add(row);
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        int count=0;
        boolean flag=true;
        long sum=0;
        int[] vis=new int[n+1];
        vis[1]=1;
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int[] j:adj.get(1)){
            q.add(new int[]{1,j[0],j[1]});
            count=count+1;
        }
        if(count<=n) {
            while (!q.isEmpty()) {

                int[] p = q.poll();
                int f = p[0];
                int g = p[1];
                int h = p[2];
                if (vis[g] == 0) {
                    vis[g] = 1;
                    count = count + 1;
                    sum = (long) sum + h;
                    for (int[] k : adj.get(g)) {
                        q.add(new int[]{g, k[0], k[1]});
                    }

                } else {
                    continue;
                }


            }
        }
        for(int i=1;i<n+1;i++){
            if(vis[i]==0){
                System.out.println("IMPOSSIBLE");
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println(sum);
        }

    }
}
