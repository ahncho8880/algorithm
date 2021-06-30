//21608
package samsungSW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SharkPrimary {
    static Scanner sc;
    static int N;
    static int[][] map;
    // static int[][] likes;
    static ArrayList<ArrayList<Integer>> likes = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        Arrays.fill(map, 0);
        for(int i=0;i<N*N;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<4;j++){
                list.add(sc.nextInt());
            }
            likes.add(list);
        }
        for(int i=0;i<N*N;i++){
            ArrayList<Integer> target = likes.get(i);
            assignSeat(target);
        }
    }

    public static void assignSeat(ArrayList<Integer> order) {
        int aX, aY;
        int max = 0;
        ArrayList<Integer> reserve = new ArrayList<>();
        int[][] scoreBoard =new int[N][N];
        Arrays.fill(scoreBoard, 0);
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]==0) {
                    scoreBoard[i][j] = generateScore(i, j, order);
                    
                }
            }
        }

    }

    private static int generateScore(int i, int j, ArrayList<Integer> order) {
        int score = 0;
        if(i+1!=N && order.contains(map[i+1][j])){
            score += 1;
        }
        if(i-1!=-1 && order.contains(map[i-1][j])){
            score += 1;
        }
        if(j+1!=N && order.contains(map[i][j+1])){
            score += 1;
        }
        if(j-1!=-1 && order.contains(map[i][j-1])){
            score += 1;
        }
        return score;
    }

    private static void aa() {

    }
}