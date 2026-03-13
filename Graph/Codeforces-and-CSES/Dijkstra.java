import java.io.*;
import java.util.*;
public class Darkroads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int m=0;
        int n=0;
        int sum=0;
        int total=0;
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        int t=1;
        while (t-- > 0) {
            // String s=br.readLine();
            // if (s==null) break;
            st = new StringTokenizer(br.readLine());
            // System.out.println(st);
            // System.out.println(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m==0 && n==0) {return;}
            // System.out.println(m);

            for(int i=0;i<m;i++){
                ArrayList<int[]> row=new ArrayList<>();
                adj.add(row);

            }
            System.out.println(adj);
            System.out.println(adj.size());
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
                int w=Integer.parseInt(st.nextToken());
                adj.get(u).add(new int[]{v,w});
                total=total+w;
                adj.get(v).add(new int[]{u,w});
            }
            int[] vis=new int[m];
            vis[0]=1;
            PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
            for(int[] j:adj.get(0)){
                q.add(new int[]{0,j[0],j[1]});
            }
            while(!q.isEmpty()){
                int[] p=q.poll();
                int f=p[0];
                int g=p[1];
                int h=p[2];
                if(vis[g]==0){
                    vis[g]=1;
                    for(int[] k:adj.get(g)){
                        q.add(new int[]{g,k[0],k[1]});
                    }
                    sum=sum+h;
                }
                else{
                    continue;
                }

            }
            System.out.println(total-sum);
            //
        }
    }

}
