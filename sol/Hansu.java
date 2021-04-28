package sol;

import java.util.Scanner;

public class Hansu{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt =0;
        for(int i=1;i<=N;i++){
            cnt += compareNum(i) ? 1 : 0;
        }
        System.out.println(cnt);
    }
    public static boolean compareNum(int num){
        String str = Integer.toString(num);
        int length = (int)(Math.log10(num)+1);
        int k =0 ,kk=0;
        int temp=10;
        for(int i=1;i<length;i++){
            k= (int) str.charAt(i) - 48;
            kk = (int) str.charAt(i-1) - 48;
            if(temp == 10){
                temp = k - kk;
            }else if(k - temp != kk){
                return false;
            }
        }
        return true;
    }
}