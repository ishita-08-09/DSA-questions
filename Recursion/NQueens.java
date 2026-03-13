import java.util.*;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for(char[] row:board)
            Arrays.fill(row,'.');

        helper(0,board,ans);

        return ans;
    }

    void helper(int col,char[][] board,List<List<String>> ans){

        if(col==board.length){

            List<String> temp = new ArrayList<>();

            for(char[] row:board)
                temp.add(new String(row));

            ans.add(temp);

            return;
        }

        for(int row=0;row<board.length;row++){

            if(isSafe(row,col,board)){

                board[row][col]='Q';

                helper(col+1,board,ans);

                board[row][col]='.';
            }
        }
    }

    boolean isSafe(int row,int col,char[][] board){

        int r=row,c=col;

        while(c>=0){
            if(board[row][c]=='Q') return false;
            c--;
        }

        r=row; c=col;

        while(r>=0 && c>=0){
            if(board[r][c]=='Q') return false;
            r--; c--;
        }

        r=row; c=col;

        while(r<board.length && c>=0){
            if(board[r][c]=='Q') return false;
            r++; c--;
        }

        return true;
    }
}