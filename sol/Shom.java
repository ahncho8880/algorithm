package sol;

import java.util.Scanner;

public class Shom {
    static int M =2147483647;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int n =1;
        while(N!=0){
            N = check666(n++) ? N-1 : N;
        }
        sc.close();
        System.out.println(n-1);
    }
    private static boolean check666(int n) {
        String str = Integer.toString(n);
        int cnt =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='6'){
                if(++cnt==3){
                    return true;
                }
            }else{
                cnt =0;
            }
        }
        return false;
    }
}