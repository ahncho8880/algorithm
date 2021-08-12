package sol;

import java.util.Scanner;

public class Z {
    static int N;
    static int r;
    static int c;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        sc.close();
        divideZ(N);
        System.out.println(ans);
    }
    
    private static void divideZ(int n) {
        if(n==0){
            return;
        } 

        if(r >= Math.pow(2, n)/2){
            if(c >= Math.pow(2,n)/2){
                //4
                ans += Math.pow(2, n) * Math.pow(2, n) * 0.75;
                r -= Math.pow(2, n-1);
                c -= Math.pow(2, n-1);
                divideZ(n-1);
            }
            else{
                //3
                ans += Math.pow(2, n) * Math.pow(2, n) * 0.5;
                r -= Math.pow(2, n-1);
                divideZ(n-1);
            }
        }
        else{
            if(c >= Math.pow(2,n)/2){
                //2
                ans += Math.pow(2, n) * Math.pow(2, n) * 0.25;
                c -= Math.pow(2, n-1);
                divideZ(n-1);
            }
            else{
                //1
                divideZ(n-1);
            }
        }
    }
}