import java.io.*;
import java.util.*;
public class Checkposts {
    int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());

        int[] size=new int[n+1];
        int index=1;
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
        int r=Integer.parseInt(st.nextToken());
        size[index]=r;
        index++;
        }
        st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            ArrayList<Integer> row=new ArrayList<>();
            ArrayList<Integer> roww=new ArrayList<>();
            adj.add(row);
            adjj.add(roww);

        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adjj.get(v).add(u);
        }
        PriorityQueue<Integer> q=new PriorityQueue<Integer>((a,b)->a-b);
        int[] finall=new int[n+1];
        int ans=0;
        long costt=0;

        long countt=1;
        Stack<Integer> ss=new Stack<>();
        boolean mode=false;
        int[] vis=new int[n+1];
        for(int i=1;i<n+1;i++){
            if(vis[i]==0){
                mode=true;
                dfs(q,size,finall,ans,i,adj,vis,ss,mode);
            }
        }
        Arrays.fill(vis,0);

        while(!ss.isEmpty()){
            int p=ss.pop();
            if(vis[p]==0){
                mode=false;
                ans=ans+1;
                q.clear();
                long count=1;
                dfs(q,size,finall,ans,p,adjj,vis,ss,mode);

                int z=q.poll();
                costt=costt+z;
                while(!q.isEmpty()){
                    int zz=q.poll();
                    if(zz==z){
                        count=(count+1)%((int)1e9+7);
                    }
                    else{
                        break;
                    }
                }

                countt=(countt*count)%((int)1e9+7);


            }
        }
        PrintWriter pw=new PrintWriter(new BufferedOutputStream(System.out));
        pw.print(costt+" ");
        pw.print(countt);
        pw.flush();



    }
    static  PriorityQueue<Integer> dfs( PriorityQueue<Integer> q,int[] size,int[] finall,int ans,int i,ArrayList<ArrayList<Integer>> a,int[] vis,Stack<Integer> ss,boolean mode){
        vis[i]=1;

        for(int j:a.get(i)){
            if(vis[j]==0){
                dfs(q,size,finall,ans,j,a,vis,ss,mode);
            }
        }
        if(mode){
            ss.push(i);
        }
        else{
            q.add(size[i]);

        }
        return q;





    }
}
