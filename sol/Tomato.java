package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tomato {
    static int M;
    static int N;
    static boolean[][] visited;
    static boolean isChange;
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        M = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());
        int[][] box = new int[N][M];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // sc.close();
        aFewMomentsLater(box, 0);
    }

    static void changeTomato(int x, int y, int[][] box){
        if(x == N || y == M || x==-1 ||y == -1){
            return;
        }
        if(box[x][y]==0){
            box[x][y] = 1;
            visited[x][y] = true;
            isChange = true;
        }
    }
    static boolean isNoZero(int[][] box){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(box[i][j]==0){
                    return false;
                } 
            }
        }
        return true;
    }
    static void aFewMomentsLater(int[][] box, int count){
        visited = new boolean[N][M];
        isChange = false;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(box[i][j] == 1 && !visited[i][j]){
                    changeTomato(i+1, j, box);
                    changeTomato(i, j+1, box);
                    changeTomato(i-1, j, box);
                    changeTomato(i, j+-1, box);
                }
            }
        }
        if(isChange){
            aFewMomentsLater(box, count + 1);
        }
        else if(!isChange && !isNoZero(box)){
            System.out.println("-1");
        }
        else{
            System.out.println(count);
        }
        // for(int i=0;i<N;i++){
        //     System.out.println(Arrays.toString(box[i]));
        // }
    }
}
