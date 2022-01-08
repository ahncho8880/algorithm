package sol;

import java.util.*;

public class Sudoku {
    static int[][] board = new int[9][9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = sc.nextInt();
            }
        }
        playSudoku();
    }

    private static void playSudoku() {
        // if(true){
        //     return;
        // }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                for(int k=1;k<=9;k++){
                    if(board[i][j]==0){
                        board[i][j] = k;
                        isRight(i, j);
                    }
                }
            }   
        }
    }

    private static boolean isRight(int n, int m) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i=0;i<9;i++){
            if(row.contains(board[n][i])){
                return false;
            }
            if(board[n][i] != 0){
                row.add(board[n][i]);
            }
            if(col.contains(board[i][m])){
                return false;
            }
            if(board[i][n] != 0){
                col.add(board[i][m]);
            }
        }

        return true;
    }

}
