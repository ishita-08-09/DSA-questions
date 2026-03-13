import java.util.*;
public class Ring_Road {
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int c=0;
    ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
    for(int i=0;i<n+1;i++){
        ArrayList<int[]> row=new ArrayList<>();
        adj.add(row);
    }
    for(int i=0;i<n;i++){
        int u=sc.nextInt();
        int v=sc.nextInt();
        int w=sc.nextInt();
        adj.get(u).add(new int[]{v,0});
        adj.get(v).add(new int[]{u,w});

    }
    int[] visited=new int[n+1];
    ArrayList<Integer> cycle=new ArrayList<>();
    int start=1;
    int curr=1;
    int prev=-1;
    int next=0;
    cycle.add(start);
    visited[start]=1;
    while(true){
        for(int[] j:adj.get(curr)){
            next=j[0];
            if(next!=prev){
                if(visited[next]==0){
                    visited[next]=1;
                    cycle.add(next);
                    prev=curr;
                    curr=next;
                    break;

                }
                else{
                    if(start==next){
                        cycle.add(start);
                        break;

                    }
                }
            }
        }
        if(cycle.get(cycle.size()-1)==start){
            break;
        }
    }
    int cost1=0;
    int cost2=0;

    for(int i=0;i<cycle.size()-1;i++){
        int u=cycle.get(i);
        int v=cycle.get(i+1);
        cost1=cost1+count(c,u,v,adj);


    }
    for(int i=cycle.size()-1;i>0;i--){
        int u=cycle.get(i);
        int v=cycle.get(i-1);
        cost2=cost2+count(c,u,v,adj);


    }
    if(cost1<cost2){
        System.out.println(cost1);
    }
    else{
        System.out.println(cost2);
    }





    }
    static int count(int c,int u,int v,ArrayList<ArrayList<int[]>> adj){
        for(int[] j:adj.get(u)){
            if (j[0]==v){
                c=j[1];
            }
        }
        return c;
    }
}
