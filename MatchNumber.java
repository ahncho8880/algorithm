import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MatchStick {
    static int[] match = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static int[][] ans;
    static int n, max, min;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] testcase = new int[n];
        ans = new int[n][2];
        for(int i=0;i<n;i++){
            testcase[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<n;i++){
            max=0;
            min=999999999;
            searchBig(testcase[i], "", 0);
            ans[i][0] = min;
            ans[i][1] = max;
        }
        printAns();
    }
    private static void printAns() throws IOException {
        for(int i=0;i<n;i++){
            System.out.println(ans[i][0]+" "+ans[i][1]);
        }
    }
    private static void searchBig(int number, String res, int length) {
        if(number<=0){
            if(number==0){
                int _res =  Integer.parseInt(res);
                max = max > _res ? max : _res;
                min = min < _res ? min : _res;
            }
            return;
        }
        for(int i=0;i<10;i++){
            if(length==0 && i==0){
                i++;
            }
            String tmp = Integer.toString(i);
            searchBig(number-match[i], res+tmp, length+1);
        }
    }
}