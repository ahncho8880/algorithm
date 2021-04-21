package samsungSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Tetromino {
    static int N, M;
    static int MAX = Integer.MIN_VALUE;
    static int[][] paper;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        for(int i=0;i<N;i++){
            StringTokenizer li = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                paper[i][j] = Integer.parseInt(li.nextToken());
            }
        }
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                test(i, j, 3, 0, visited);
                calFirstT(i, j, 3, 0);
                calSecondT(i, j, 3, 0);
            }
        }
        bw.write(MAX+"\n");
        bw.close();
    }
    private static void calFirstT(int x, int y, int length, int sum) {
        if(x==N || y==M || x==-1 || y==-1){
            return;
        }
        if(length==0){
            MAX = Math.max(MAX, sum+paper[x][y]);
            return;
        }
        if(length==1){
            calFirstT(x-1, y+1, length-1, sum+paper[x][y]);
            calFirstT(x-1, y-1, length-1, sum+paper[x][y]);
        }
        calFirstT(x+1, y, length-1, sum+paper[x][y]);
    }
    private static void calSecondT(int x, int y, int length, int sum) {
        if(x==N || y==M || x==-1 || y==-1){
            return;
        }
        if(length==0){
            MAX = Math.max(MAX, sum+paper[x][y]);
            return;
        }
        if(length==1){
            calSecondT(x+1, y-1, length-1, sum+paper[x][y]);
            calSecondT(x-1, y-1, length-1, sum+paper[x][y]);
        }
        calSecondT(x, y+1, length-1, sum+paper[x][y]);
    }
    
    private static void test(int x, int y, int length, int sum, boolean[][] visited) {
        if(x==N || y==M || x==-1 || y==-1 || visited[x][y]){
            return;
        }
        if(length==0){
            MAX = Math.max(MAX, sum+paper[x][y]);
            return;
        }
        visited[x][y] = true;
        test(x+1, y, length-1, sum+paper[x][y], visited);
        test(x-1, y, length-1, sum+paper[x][y], visited);
        test(x, y+1, length-1, sum+paper[x][y], visited);
        test(x, y-1, length-1, sum+paper[x][y], visited);
        visited[x][y] = false;
    }
}
