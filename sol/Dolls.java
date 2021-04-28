package sol;

import java.util.*;

public class Dolls {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int k = input.nextInt();
        int[] dolls = new int[N];
        double min = -1;
        for(int i=0;i<dolls.length;i++)
            dolls[i] = input.nextInt();
        
        while(k<=N){
            for(int i=0;i<=N-k;i++){
                double m=0;
                for(int j=0 ;j<k;j++)
                    m+=dolls[j+i];
                m /= k;
                double mm=0;
                for(int j=0 ;j<k;j++){
                    mm+=(dolls[i+j]-m)*(dolls[i+j]-m);
                }
                mm = Math.sqrt(mm/k);
                min = Double.compare(-1, min)!=0 ? Math.min(min, mm) : mm;
            }
            k++;
        }
        System.out.println(min);
    }
}
