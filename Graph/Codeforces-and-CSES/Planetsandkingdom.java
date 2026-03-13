import java.io.*;
import java.util.*;
public class Planetsandkingdom {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
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
        int[] finall=new int[n+1];
        int ans=0;
        Stack<Integer> s=new Stack<>();
        boolean mode=false;
        int[] vis=new int[n+1];
        for(int i=1;i<n+1;i++){
            if(vis[i]==0){
                mode=true;
                dfs(finall,ans,i,adj,vis,s,mode);
            }
        }
        Arrays.fill(vis,0);

        while(!s.isEmpty()){
            int p=s.pop();
            if(vis[p]==0){
                mode=false;
                ans=ans+1;
                dfs(finall,ans,p,adjj,vis,s,mode);

            }
        }
        PrintWriter pw=new PrintWriter(new BufferedOutputStream(System.out));
        pw.println(ans);
        for(int k=1;k<finall.length;k++){
            pw.print(finall[k]+" ");
        }
        pw.flush();

    }
    static void dfs(int[] finall,int ans,int i,ArrayList<ArrayList<Integer>> a,int[] vis,Stack<Integer> s,boolean mode){
        vis[i]=1;

        for(int j:a.get(i)){
            if(vis[j]==0){
                dfs(finall,ans,j,a,vis,s,mode);
            }
        }
        if(mode){
            s.push(i);
        }
        else{
            finall[i]=ans;
        }




    }
}
