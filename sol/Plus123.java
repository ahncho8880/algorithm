package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Plus123 {
    static int N, count;
    static int[] numbers = {1,2,3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] cases = new int[N];
        for(int i=0;i<N;i++){
            cases[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<N;i++){
            count =0;
            searchCase(cases[i],0);
            System.out.println(count);
        }
        
    }
    private static void searchCase(int goal, int sum) {
        if(sum>=goal){
            if(sum == goal){
                count++;
            }
            return;
        }
        
        sum+=numbers[0];
        searchCase(goal, sum);
        sum-=numbers[0];

        sum+=numbers[1];
        searchCase(goal, sum);
        sum-=numbers[1];

        sum+=numbers[2];
        searchCase(goal, sum);
        sum-=numbers[2];
        
    }
}
