import java.util.*;
public class Party {
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int level=0;
        int level_size=0;
        Queue<Integer> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> row=new ArrayList<>();
            adj.add(row);
        }
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            adj.get(l.get(i)).add(i);
        }
        for(int i=0;i<n;i++){
            if (l.get(i)==-1){
                q.add(i);

            }
        }
        while(!q.isEmpty()){
            level_size=q.size();
            level=level+1;

            while(level_size>0){
                int p=q.poll();
                level_size=level_size-1;
                for(int j:adj.get(p)){
                    q.add(j);
                }
            }
        }
        System.out.println(level);

    }

}


