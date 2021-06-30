package sol;

import java.util.Scanner;

public class Nqueen {
    static int[] col;
    static int answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0 ; i < n ; ++i) {
            col = new int[n];
            col[0] = i;
            backtracking(n, 1);
        }
        System.out.println(answer);
    }

    private static void backtracking(int max, int row){
        if(row == max){
            answer++;
            col[row - 1] = 0;
            return;
        }
        
        for(int i = 0 ; i < max ; ++i){
            col[row] = i;
            if(isPossible(row)){
                backtracking(max, row + 1);
            } 
        }
        col[row] = 0;
    }

    private static boolean isPossible(int row){
        for(int i = 0 ; i < row ; ++i){
            if(col[i] == col[row]) return false;
            if(Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }
        return true;
    }


}
