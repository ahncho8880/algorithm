package samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dummy {
    static int N, K, L;
    static ArrayList<int[]> snake = new ArrayList<>();
    static ArrayList<int[]> apples = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        int[][] coords = new int[K][2];
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            coords[i][1] = Integer.parseInt(st.nextToken())-1;
            coords[i][0] = Integer.parseInt(st.nextToken())-1;
            apples.add(coords[i]);
        }
        L = Integer.parseInt(br.readLine());
        String[][] moves = new String[L][2]; 
        for(int i=0;i<L;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            moves[i][0] = st.nextToken();
            moves[i][1] = st.nextToken();
        }
        int[] init = {0,0};
        snake.add(init);
        goSnake(moves,  snake.size(), 1, 'r');
    }
    private static void goSnake(String[][] moves, int length, int sec, char direction) {
        int[] snakeHead = snake.get(length-1).clone();
        //step1
        int[] tempHead = snakeHead;
        if(direction=='r'){ 
            tempHead[0] += 1;
        }else if(direction=='l'){
            tempHead[0] -= 1;
        }else if(direction=='u'){
            tempHead[1] -= 1;
        }else if(direction=='d'){
            tempHead[1] += 1;
        }
        //exit_case
        if(snakeHead[0] == N || snakeHead[1] == N || snakeHead[0] == -1 || snakeHead[1] == -1){
            System.out.println(sec);
            return;
        }
        for(int i=0 ;i<snake.size();i++){
            if(Arrays.equals(snakeHead, snake.get(i))){
                System.out.println(sec);
                return;
            }
        }
        snake.add(tempHead);
        //step2
        boolean isApple = false;
        for(int i=0;i<apples.size();i++){
            if(Arrays.equals(apples.get(i), tempHead)){
                apples.remove(i);
                isApple = true;
            }
        }
        //step3
        if(!isApple){
            snake.remove(0);   
        }      
        for(String[] move : moves){
            int moveSec = Integer.parseInt(move[0]);
            char moveDir = move[1].charAt(0);
            if(moveSec==sec){
                if(direction=='r'){
                    if(moveDir=='D'){
                        direction = 'd';
                    }else{
                        direction = 'u';
                    }
                }else if(direction=='l'){
                    if(moveDir=='D'){
                        direction = 'u';
                    }else{
                        direction = 'd';
                    }
                }else if(direction=='u'){
                    if(moveDir=='D'){
                        direction = 'r';
                    }else{
                        direction = 'l';
                    }
                }else if(direction=='d'){
                    if(moveDir=='D'){
                        direction = 'l';
                    }else{
                        direction = 'r';
                    }
                }
            }
        }
        goSnake(moves, snake.size(), sec+1, direction);
    }
}
