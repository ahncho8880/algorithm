import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Election {
    static int N;
    static int[] candidates;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candidates = new int[N];
        for(int i=0;i<N;i++){
            candidates[i] = Integer.parseInt(br.readLine());
        }
        manipulate(0);
    }
    private static void manipulate(int cnt) {
        if(isChampion()){
            System.out.println(cnt);
            return;
        }
        int max = 0, tmp=0;
        for(int i=1;i<N;i++){
            if(candidates[i] > max){
                max = candidates[i];          
                tmp = i;
            }
        }
        candidates[0]+=1;
        candidates[tmp]-=1;
        manipulate(cnt+1);
    }
    private static boolean isChampion() {
        int win = candidates[0];
        for(int i=1;i<N;i++){
            if(win<=candidates[i]){
                return false;
            }
        }
        return true;
    }
}
