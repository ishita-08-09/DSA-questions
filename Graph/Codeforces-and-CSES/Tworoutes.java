import java.io.*;
import java.util.*;
public class Tworoutes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            ArrayList<Integer> roww = new ArrayList<>();
            adj.add(row);
            adjj.add(roww);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            arr.add(i);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 1; i < n + 1; i++) {
            for (int k = 0; k < arr.size(); k++) {
                if (!adj.get(i).contains(arr.get(k)) && arr.get(k)!=i) {
                    adjj.get(i).add(arr.get(k));
                }
            }
        }
        boolean flag=false;
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        int level_size = 0;
        int[] vis1 = new int[n + 1];
        int[] vis2 = new int[n + 1];
        vis1[1] = 1;
        vis2[1] = 1;

//        System.out.println(adj);
//        System.out.println(adjj);

        if(adj.get(1).contains(n)){

            int b = func(n,1, adjj,q,ans,level_size,vis2,flag);
//            System.out.println(b+" ok");
            if(vis2[n]==0){
                System.out.println("-1");
            }
            else{
                System.out.println(b);
            }
        }
        else{
            int a = func(n,1, adj,q,ans,level_size,vis1,flag);
            if(vis1[n]==0){
                System.out.println("-1");
            }
            else{
                System.out.println(a);
            }
        }
    }


    static int func(int n,int i, ArrayList<ArrayList<Integer>> ad, Queue<Integer> q,int ans,int level_size,int[] vis,boolean flag) {
        ans=0;
        q.add(i);
//        ans=ans+1;

        while (!q.isEmpty()) {
            level_size = q.size();
            flag=false;
            while (level_size > 0) {
                int p = q.poll();
                if(p==n) break;
                level_size = level_size - 1;
                for (int j : ad.get(p)) {
                    if (vis[j] == 0) {
                        vis[j] = 1;
                        q.add(j);
                        flag = true;

                    }
                }
            }
            if (flag) {
                ans = ans + 1;
            }
        }
        return ans;
    }
}
