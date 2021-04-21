package samsungSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiceGame {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] order;
    static int[] dice = new int[6];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        order = new int[K];
        for(int i=0;i<N;i++){
            StringTokenizer li = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(li.nextToken());
            }
        }
        StringTokenizer li2 = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            order[i] = Integer.parseInt(li2.nextToken());
        }
        Arrays.fill(dice, 0); 
        for(int i=0;i<K;i++){
            rollDice(order[i]);
        }
        bw.close();
    }
    private static void rollDice(int move) throws IOException {
        int dx = x, dy = y;
        if(move==1){
            dy+=1;     
        }else if(move==2){
            dy-=1;
        }else if(move==3){
            dx-=1;
        }else if(move==4){
            dx+=1;
        }
        if(dx>=N || dx<0 || dy>=M || dy<0){
            return;
        }
        if(map[x][y]==0){
            map[x][y] = dice[5];
        }else{
            dice[5] = map[x][y];
            map[x][y] = 0;
        }
        setDice(move);
        x=dx;
        y=dy;
        bw.write(dice[0]+"\n");
    }
    private static void setDice(int move){
        int top=-1;
        if(move==1){
            top = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[2];
            dice[2] = top;
        }else if(move==2){
            top = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[3];
            dice[3] = top;
        }else if(move==3){
            top = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[1];
            dice[1] = top;
        }else if(move==4){
            top = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[4];
            dice[4] = top;
        }
    }
}
