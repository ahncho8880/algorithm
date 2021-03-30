import java.util.ArrayList;
import java.util.Scanner;

public class Dolls {
    static int N, K;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        K = input.nextInt();
        int[] dolls = new int[N];
        int sum=0;
        for(int i = 0;i<N;i++){
            dolls[i] = input.nextInt();
            sum+=dolls[i];
        }
        double min=-1;
        for(int k=K;k<=N;k++){
            int start =0;
            while(start+K <= N){
                int[] dollSds = new int[K];
                int sum2=0;
                int n=0;
                for(int i=start;i<K+start;i++){
                    dollSds[n++] = dolls[i]; 
                    sum2 += dolls[i];
                }
                float m = (float)sum2/K;
                double tmp = sd(dollSds, m);
                min = (Double.compare(min, -1)==0 || min>tmp) ? tmp : min;
                start++;
            }
        }
        min = Double.parseDouble(String.format("%.11f", min));
        System.out.println(min);
    }
    private static double sd(int[] dollSds, float m) {
        double sum = 0;
        for(int i=0;i<K;i++){
            sum+= Math.pow((dollSds[i]-m),2);
        }
        return Math.sqrt(sum/K);
    }
}
