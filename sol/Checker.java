package sol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Checker {
    static int N, ans=0;
    static String[] sentence;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N =Integer.parseInt(br.readLine());
        sentence = new String[N];
        for(int i=0;i<N;i++){
            sentence[i] = br.readLine();
        }
        for(int i=0;i<N;i++){
            ans += isGroupSentence(sentence[i]) ? 1 : 0;
        }
        bw.write(ans+"\n");
        bw.close();
    }
    private static boolean isGroupSentence(String input) {
        HashSet<Character> group = new HashSet<>();
        char head = input.charAt(0);
        group.add(head);
        for(int i=1;i<input.length();i++){
            char temp = input.charAt(i);
            if(temp!=head && group.contains(temp)){
               return false; 
            }
            group.add(temp);
            head = temp;
        }
        return true;
    }
}
