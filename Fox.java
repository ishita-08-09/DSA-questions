//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Fox {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] dx={0,0,-1,+1};
        int[] dy={-1,+1,0,0};
        int nx=0;
        int ny=0;
        char[][]  grid=new char[n][m];
        for(int i=0;i<n;i++){
            String s=sc.next();
            for(int j=0;j<m;j++){
                grid[i][j]=s.charAt(j);
            }
        }
        if(is_cyclic(n,m,dx,dy,nx,ny,grid)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    static boolean is_cyclic(int n,int m,int[] dx,int[] dy,int nx,int ny,char[][] grid){

        int k=0;
        int[][] curr_path=new int[n][m];
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0){
                    k=0;
                    if(dfs(i,j,vis,curr_path,k,dx,dy,nx,ny,n,m,grid)){
                        return true;
                    }
                }
            }

    }
        return false;
    }
    static boolean dfs(int i,int j,  int[][] vis, int[][] curr_path,int k,int[] dx,int[] dy,int nx,int ny,int n,int m,char[][]  grid){
        vis[i][j]=1;
        curr_path[i][j]=1;
        k=k+1;
        for(int p=0;p<=3;p++){
            nx=i+dx[p];
            ny=j+dy[p];
            if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==grid[i][j]){
                if (vis[nx][ny]==0){
                    if(dfs(nx,ny,vis,curr_path,k,dx,dy,nx,ny,n,m,grid)){
                        return true;
                    }
                }
                else{
                    if(curr_path[nx][ny]==1 && k>=4){
                        return true;
                    }
                }

            }
        }
        curr_path[i][j]=0;
        return false;





    }

}
