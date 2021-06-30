//1032
package sol;

import java.util.Scanner;

public class CommandPrompt {
    static int N;
    static String[] words;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        words = new String[N];
        for(int i=0;i<N;i++){
            words[i] = sc.next();
        }
        if(N==1){
            System.out.println(words[0]);
        } else {
            System.out.println(searchWord());
        }
    }

    private static String searchWord() {
        int len = words[0].length();
        
        String word = "";
        for(int i=0;i<len;i++){
            String tmp = "";
            int count = 0;
            for(int j=1;j<words.length;j++) {
                tmp = words[j].charAt(i) +"";
                if(tmp.equals(words[j-1].charAt(i)+"")){
                    count += 1;
                }
            }
            if(count==words.length-1){
                word += tmp;
            } else {
                word += "?";
            }
        }
        return word;
    }
}
