package sol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class VPS {
    static int N;
    static String[] brackets;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        brackets = new String[N];
        for(int i=0;i<brackets.length;i++){
            brackets[i] = br.readLine();
        }
        for(int i=0;i<brackets.length;i++){
            bw.write(getValid(brackets[i])+"\n");
        }
        bw.close();
    }

    private static String getValid(String bracket) {
        int sum = 0;
        int pointer = 0;
        while(pointer < bracket.length()){
            char cur = bracket.charAt(pointer++);
            sum += cur=='(' ? 1 : -1;
            if(sum==-1){
                return String.format("NO");
            }
        }
        if(sum!=0){
            return String.format("NO");
        }
        return String.format("YES");
    }
    
}
