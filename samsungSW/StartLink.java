package samsungSW;

import java.util.Scanner;

public class StartLink{
    static int N, MIN=999999999;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] chem = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                chem[i][j]=sc.nextInt();
            }
        }
        boolean[] team = new boolean[N];
        divideTeam(team, chem, 0, N/2);
        System.out.println(MIN);
    }
    private static void divideTeam(boolean[] team, int[][] chem, int start, int n) {
        if(n==0){
            cal(team, chem);
            return;
        }
        for(int i=start;i<N;i++){
            team[i] = true;
            divideTeam(team, chem, i+1, n-1);
            team[i] = false;         
        }
    }
    private static void cal(boolean[] team, int[][] chem) {
        int res,sumA=0,sumB=0;
        for(int i=0;i<N;i++){
            if(team[i]){
                for(int j=0;j<N;j++){
                    sumA+= team[j] ? chem[i][j] : 0;
                }
            }else{
                for(int j=0;j<N;j++){
                    sumB+= !team[j] ? chem[i][j] : 0;
                }
            }
        }
        res = sumA>sumB?sumA-sumB:sumB-sumA;
        MIN = res < MIN ? res: MIN;
    }
}