package blackjack;

import java.util.Arrays;
import java.util.Scanner;

public class Blackjack {
    static int N,M, ANS=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M= sc.nextInt();
        int[] cards = new int[N];
        boolean[] picked = new boolean[N];
        for(int i=0;i<N;i++){
            cards[i] = sc.nextInt();
        }
        btking(cards, picked, 0, 3);
        
        System.out.println(ANS);

    }
    private static void btking(int[] cards, boolean[] picked, int s, int r){
        if(r==0){
            cal(cards, picked);
            return;
        }
        for(int i=s;i<N;i++){
            picked[i] = true;
            btking(cards, picked, i+1, r-1);
            picked[i] = false;
        }

    }
    private static void cal(int[] cards, boolean[] picked) {
        int sum=0;
        for(int i=0;i<picked.length;i++){
            if(picked[i]){
                sum+=cards[i];
            }
        }
        if(sum <= M && (M-ANS) > (M-sum)){
            ANS = sum;
        }
    }
}
