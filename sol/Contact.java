package sol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class Contact {
    static final String regex = "(100{1,}1{1,}|01){1,}";
    static int T;
    static String[] testCase;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        testCase = new String[T];
        for(int i=0;i<T;i++){
            testCase[i] = br.readLine();
        }
        sol();
    }

    private static void sol() throws IOException {
        boolean isMatch;
        for(int i=0;i<T;i++){
            isMatch = Pattern.matches(regex, testCase[i]);
            bw.write(isMatch ? "YES\n" : "NO\n");
        }
        bw.close();
    }
}
