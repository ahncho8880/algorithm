package samsungSW;

import java.util.Scanner;

public class Fired{
    static int N, MAX=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] schedules = new int[N][2];
        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                schedules[i][j] = sc.nextInt();
            }
        }
        pickSchedules(schedules, 0, 0);
        System.out.println(MAX);

    }
    private static void pickSchedules(int[][] schedules, int start, int price){
        MAX = price > MAX ? price : MAX;
          
        for(int i=start;i<N;i++){
            if(i+schedules[i][0]<=N){
                price+=schedules[i][1];
                pickSchedules(schedules, i+schedules[i][0], price);
                price-=schedules[i][1];
            }
        }
    }
}