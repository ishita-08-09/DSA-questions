import java.util.*;
public class Fox_and_names {
    public static void main(String[] args) {
        int m = 0;
        StringBuilder ans=new StringBuilder();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<26;i++){
            ArrayList<Integer> row=new ArrayList<>();
            adj.add(row);
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            words[i] = s;
        }
        int[] indegree = new int[26];
        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s1.length() <= s2.length()) {
                m = s1.length();

            }
            else{
                if(s1.startsWith(s2)){
                    System.out.println("Impossible");
                    return;

                }
                m=Math.min(s1.length(),s2.length());

            }

            for (int j = 0; j < m; j++) {
                  if(s1.charAt(j)!=s2.charAt(j)){
                      int u=s1.charAt(j)-'a';
                      int v=s2.charAt(j)-'a';
                      if(!(adj.get(u).contains(v))){
                          adj.get(u).add(v);
                          indegree[v]=indegree[v]+1;

                      }
                      break;





                  }
            }


        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<26;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int p=q.poll();
            ans.append((char)(p+'a'));
            for(int j:adj.get(p)){
                indegree[j]=indegree[j]-1;
                if(indegree[j]==0){
                    q.add(j);
                }
            }
        }
        if(ans.length()==26){
            System.out.println(ans.toString());
        }
        else{
            System.out.println("Impossible");
        }


    }
}
