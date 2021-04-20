import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MatchNumber {
    static int[] match = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static long[][] ans;
    static int N;
    static String max;
    static long[] min = new long[101];
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] testcase = new int[N];
        ans = new long[N][2];
        for(int i=0;i<N;i++){
            testcase[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<N;i++){
            max="-1";
            searchBig(testcase[i], "", 0);
            // searchSmall(testcase[i], "", 0);
            setMin();
            bw.write(min[testcase[i]]+" "+max+"\n");
        }
        bw.close();
    }
    private static void searchBig(int number, String res, int length) {
        if(number<=0){
            if(number==0){
                max = res.length() > max.length() || max.equals("-1") ? res : max;
            }
            return;
        }
        String tmp = "";
        if(length!=0){
            tmp="1";
            searchBig(number-match[1], res+tmp, length+1);
        }else{
            for(int i=1;i<10;i++){
                tmp = Integer.toString(Integer.valueOf(i));
                if(length!=0){
                    tmp="1";
                }
                searchBig(number-match[i], res+tmp, length+1);
            }
        }
    }
    // private static void searchSmall(int number, String res, int length) {
    //     if(number<=0){
    //         int head = res.charAt(0)-'0';
    //         if(head!=0 && number==0){
    //             long a = Long.parseLong(res);
    //             long b = Long.parseLong(min);
    //             min = a < b || min.equals("-1") ? res : min;
    //         }
    //         return;
    //     }
    //     String tmp="";
    //     if(number > 13){
    //         tmp="8";
    //         searchSmall(number-match[8], tmp+res, length+1);
    //     }else{
    //         for(int i=0;i<10;i++){
    //             tmp = Integer.toString(Integer.valueOf(i));
    //             searchSmall(number-match[i], tmp+res, length+1);
    //         }
    //     }
    // }
    private static void setMin(){
        Arrays.fill(min, Long.MAX_VALUE);
        min[2] = 1;
        min[3] = 7;
        min[4] = 4;
        min[5] = 2;
        min[6] = 6;
        min[7] = 8;
        min[8] = 10;
        String[] add = {"1", "7", "4", "2", "0", "8"};
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                String curr = min[i - j] + add[j-2];
                min[i] = Math.min(min[i], Long.parseLong(curr));
            }
        }
    }
}