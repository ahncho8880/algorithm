package reverse;

import java.util.ArrayList;
import java.util.Scanner;

public class Reverse {
    static int N, M;
    static int ANS=1 ,MOD=1000000007;
    static ArrayList<String[][]> list = new ArrayList<String[][]>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        String[][] boards = new String[N][M];
        for(int i=0;i<N;i++){
            boards[i] = sc.next().split("");
        }
        doReverse(boards);
    }
    private static void doReverse(String[][] boards) {
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(isPossible(boards, i, j)){
                    cnt++;
                }
            }
        }
        for(int i=0;i<cnt;i++){
            ANS*=2%MOD;
        }
        System.out.println(ANS);
    }
    private static boolean isPossible(String[][] boards, int i, int j) {
        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};
        char color = boards[i][j].charAt(0);
        for(int k=0;k<4;k++){
            int tmpX = i+x[k];
            int tmpY = j+y[k];
            if(!(tmpX<0 || tmpX>=N || tmpY<0 || tmpY>=M) && color!=boards[tmpX][tmpY].charAt(0)){
                return false;
            }
        }
        return true;
    }
}