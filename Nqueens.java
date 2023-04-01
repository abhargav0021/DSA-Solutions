import java.util.ArrayList;
import java.util.Collections;

public class Nqueens {
    ArrayList<ArrayList<String>> ans;

    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ans = new ArrayList<>();
        //hashing- leftRow, upperDiagonalRow, lowerDiagonalRow
        ArrayList<Integer> leftRow = new ArrayList<>(Collections.nCopies(A, 0));
        ArrayList<Integer> upperDiagonalRow = new ArrayList<>(Collections.nCopies(2*A-1, 0));
        ArrayList<Integer> lowerDiagonalRow = new ArrayList<>(Collections.nCopies(2*A-1, 0));
        //Collections.fill(leftRow,0);Collections.fill(lowerDiagonalRow,0);Collections.fill(upperDiagonalRow,0);
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        ArrayList<String> s = new ArrayList<>();
        for(int i=0;i<A;i++){
            s.add(".");
        }
        for(int i=0;i<A;i++){
            board.add(s);
        }
        return ans;
    }

    void solveNQueensHelper(ArrayList<ArrayList<String>> board, int col,int n,ArrayList<Integer> leftRow
            ,ArrayList<Integer> upperDiagonalRow,ArrayList<Integer> lowerDiagonalRow){
        //base case
        if(col == n){
            ans.add(construct(board));
            return;
        }
        //recursive case
        for(int i=0; i<n;i++){
            if(leftRow.get(i) == 0 && lowerDiagonalRow.get(i+col)==0 && upperDiagonalRow.get(((n-1)+(col-i)))==0){
                board.get(i).set(col,"Q");
                leftRow.set(i,1);
                lowerDiagonalRow.set(i+col, 1);
                upperDiagonalRow.set((n-1)+(col-i), 1);
                solveNQueensHelper(board,col+1,n,leftRow,lowerDiagonalRow,upperDiagonalRow);
                //backtracking- resetting the original vlaue in the ArrayList
                board.get(i).set(col,".");
                leftRow.set(i,0);
                lowerDiagonalRow.set(i+col, 0);
                upperDiagonalRow.set((n-1)-(col-i), 0);
            }
        }
    }

    ArrayList<String> construct(ArrayList<ArrayList<String>> board){
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<board.size();i++){
            String s = new String(String.valueOf(board.get(i)));
            res.add(s);
        }
        return res;
    }
}
