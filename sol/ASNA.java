package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ASNA  {
    static int T;
    static int x, y;
    static StringBuilder ans = new StringBuilder();
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            goShip(y-x, 1, 1);
            ans.append(min).append("\n");
        }
        System.out.println(ans);
    }
    private static void goShip(int distance, int n, int count) {
        if(distance<=0){
            return;
        }
        if(distance==1 && n==1){
            min = Math.min(min, count);
            return;
        }
        distance -= n;
        if(n-1!=0){
            goShip(distance, n-1, count+1);
        }
        goShip(distance, n, count+1);
        goShip(distance, n+1, count+1);
    }
}
