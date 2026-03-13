import java.io.*;
import java.util.*;
public class Buglife {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        for(int ii=0;ii<n;ii++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
            for(int k=0;k<b+1;k++){
                ArrayList<Integer> row=new ArrayList<>();
                adj.add(row);
            }
            for(int k = 0; k < i; k++) {
                st=new StringTokenizer(br.readLine());
                 int u=Integer.parseInt(st.nextToken());
                 int v=Integer.parseInt(st.nextToken());
                 adj.get(u).add(v);
                 adj.get(v).add(u);
            }
            int[] color=new int[b+1];
            int[] color=new int[b+1];
            Arrays.fill(-1);
            Queue<Integer> q=new LinkedList<>();
            q.add(1);
            color[1]=1;
            while(!q.isEmpty()){
                int p=q.poll();
                for(int j:adj.get(p)){
                    if (color[j]==-1){
                        color[j]=2;
                        q.add(j);
                    }
                    else if(color[j]==color[p]){

                    }
                }

            }
        }
}}
