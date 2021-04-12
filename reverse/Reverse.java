package reverse;

import java.util.Arrays;
import java.util.Scanner;

public class Reverse {
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        String[][] boards = new String[N][M];
        for(int i=0;i<N;i++){
            boards[i] = sc.next().split("");
        }
        doPick(boards);
        
    }
    private static void doPick(String[][] boards) {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(boards[i][j]+"");
            }
            System.out.println();
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(flag(i,j, boards)){
                    System.out.println(i+", "+j);
                    doReverse(boards, i, j);           
                    doPick(boards);
                    doReverse(boards, i, j);
                }
            }
        }
    }
    private static String[][] doReverse(String[][] boards, int i, int j){
        if(boards[i][j].equals("W")){
            boards[i][j]="B";
            if(i+1<N){
                boards[i+1][j] = "B";
            }
            if(i-1>=0){
                boards[i-1][j] = "B";
            }
            if(j+1<M){
                boards[i][j+1] = "B";
            }
            if(j-1>=M){
                boards[i][j-1] = "B";
            }
        }else{
            boards[i][j]="W";
            if(i+1<N){
                boards[i+1][j] = "W";
            }
            if(i-1>=0){
                boards[i-1][j] = "W";
            }
            if(j+1<M){
                boards[i][j+1] = "W";
            }
            if(j-1>=M){
                boards[i][j-1] = "W";
            }
        }
        return boards;
    }
    private static boolean flag(int x, int y, String[][] boards) {
        String res = boards[x][y];
        if(x+1<N && !boards[x+1][y].equals(res)){
            return false;
        }
        if(x-1>=0 && !boards[x-1][y].equals(res)){
            return false;
        }
        if(y+1<M && !boards[x][y+1].equals(res)){
            return false;
        }
        if(y-1>=0 && !boards[x][y-1].equals(res)){
            return false;
        }
        return true;
    }
}
