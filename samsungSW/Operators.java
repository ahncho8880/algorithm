package samsungSW;

import java.util.Scanner;

public class Operators {
    static int N , MAX=-1000000000, MIN=1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] numbers = new int[N];
        int[] opers = new int[4];
        for(int i=0;i<N;i++){
            numbers[i] = sc.nextInt();
        }
        for(int i=0;i<4;i++){
            opers[i] = sc.nextInt();
        }
        combinateX(numbers,opers,1,N-1,numbers[0]);
        System.out.println(MAX);
        System.out.println(MIN);
        sc.close();
    }
    private static void combinateX(int[] numbers, int[] opers,int s, int n,int res) {
        if(n==0){
            MAX = MAX > res ? MAX : res;
            MIN = MIN < res ? MIN : res;
            return;
        }
        for(int i=s;i<N;i++){
            if(opers[0]>0){
                opers[0] -= 1; 
                res+=numbers[i];
                combinateX(numbers, opers, i+1, n-1, res);
                res-=numbers[i];
                opers[0] += 1; 
            }
            if(opers[1]>0){
                opers[1] -= 1; 
                res-=numbers[i];
                combinateX(numbers, opers, i+1, n-1, res);
                res+=numbers[i];
                opers[1] += 1; 
            }
            if(opers[2]>0){
                opers[2] -= 1; 
                res*=numbers[i];
                combinateX(numbers, opers, i+1, n-1, res);
                res/=numbers[i];
                opers[2] += 1; 
            }
            if(opers[3]>0){
                opers[3] -= 1; 
                res/=numbers[i];
                combinateX(numbers, opers, i+1, n-1, res);
                res*=numbers[i];                
                opers[3] += 1; 
            }
        }    
    }
}