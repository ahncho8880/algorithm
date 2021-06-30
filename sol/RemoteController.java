//1107
package sol;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoteController {
    static String N;
    static int M;
    static ArrayList<Integer> jam;
    static int cur = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.next();
        M = sc.nextInt();
        jam = new ArrayList<>();
        for(int i=0;i<M;i++){
            jam.add(sc.nextInt());
        }
        sc.close();
        int ans = Math.abs(cur - Integer.parseInt(N));
        if(M < 10){
            int upNum = Integer.parseInt(N);
            int downNum = Integer.parseInt(N);
            int count = 0;
            boolean isOn = true;
            while(isOn){
                if(checkChannel(upNum)){
                    ans = Math.min(Integer.toString(upNum).length() + count, ans);
                    isOn = false;
                }
                if(checkChannel(downNum)){
                    ans = Math.min(Integer.toString(downNum).length() + count, ans);
                    isOn = false;
                }
                downNum = downNum < 0 ? 0 : downNum;
                upNum++;
                downNum--;
                count++;
            }
        }
        System.out.println(ans);
    }
    
    private static boolean checkChannel(int n) {
        String strN = String.valueOf(n);
        for(int i=0;i<strN.length();i++){
            if(jam.contains(strN.charAt(i)-'0')){
                return false;
            }
        }
        return true;
    }
}