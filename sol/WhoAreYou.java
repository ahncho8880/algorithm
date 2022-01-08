//1764
package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class WhoAreYou {
    static int N, M;
    static Set<String> noHear;
    static List<String> answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        noHear = new HashSet<>();
        answer = new ArrayList<>();
        for(int i=0;i<N;i++){
            noHear.add(br.readLine());
        }
        for(int i=0;i<M;i++){
            String target = br.readLine();
            if(noHear.contains(target)){
                answer.add(target);
            };
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for(String str : answer){
            System.out.println(str);
        }
    }
}
