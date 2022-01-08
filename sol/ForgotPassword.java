package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class ForgotPassword {
    static int N;
    static int M;
    static Map<String,String> addressMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());     
            addressMap.put(st.nextToken(), st.nextToken());
        }
        for(int i=0;i<M;i++){
            String target = br.readLine();
            System.out.println(addressMap.get(target));
        }
    }
}
