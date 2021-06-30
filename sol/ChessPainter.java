//1018
package sol;

import java.util.Scanner;

public class ChessPainter {
    static int M;
    static int N;
    static String[][] board;
    static char[] colors1 = new char[]{'W','B'};
    static char[] colors2 = new char[]{'B','W'};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        board = new String[M][N];
        for(int i=0;i<M;i++){
            board[i] = sc.next().split("");
        }
        sc.close();
        cutBoard();
        System.out.println(ans);
    }

    private static void cutBoard() {
        for(int i=0;i<=M-8;i++){
            for(int j=0;j<=N-8;j++){
                generateBoard(i, j);
            }
        }
    }

    private static void generateBoard(int dm, int dn) {
        String[][]  tempBoard = new String[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tempBoard[i][j] = board[i+dm][j+dn];
            }
        }
        fixBoard(tempBoard);
    }

    private static void fixBoard(String[][] tempBoard) {
        int fixCount1 = 0;
        int fixCount2 = 0;
        int fixCount;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                fixCount1 += colors1[(i+j)%2] != tempBoard[i][j].charAt(0) ? 1 : 0;
                fixCount2 += colors2[(i+j)%2] != tempBoard[i][j].charAt(0) ? 1 : 0;
            }
        }
        fixCount = Math.min(fixCount1, fixCount2);
        ans = Math.min(fixCount, ans);
    }
}
