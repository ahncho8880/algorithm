package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    static int N;
    static int[] P;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                ans += P[j];
            }
        }
        System.out.println(ans);
    }
}
