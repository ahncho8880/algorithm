package codingtest;

import java.util.Arrays;

public class GiftCard {
    static int MIN =-1;
    public static void main(String[] args) {
        // int[] gift_cards = {4,5,3,2,1};
        // int[] wants = {2,4,4,5,1};
        // int[] gift_cards = {5,4,5,4,5};
        // int[] wants = {1,2,3,5,4};
        int[] gift_cards = {2,4,1,8,9};
        int[] wants = {1,2,3,5,4};

        solution(gift_cards, wants);
    }

    private static void solution(int[] gift_cards, int[] wants) {
        int n = gift_cards.length;
        boolean[] changed = new boolean[n];
        sol(changed, gift_cards, 0, wants);   
        System.out.println(MIN);     
    }
    private static void sol(boolean[] changed, int[] cards, int r, int[] wants){
        int n = cards.length;
        int temp = matchCards(cards,wants);
        MIN = MIN > temp || MIN ==-1 ? temp : MIN;
        System.out.println(Arrays.toString(cards));
        for(int i=0;i<n;i++){
            if(cards[i]==wants[i])
                changed[i] = true;
            for(int j=0 ;j<n;j++){
                if(!changed[i] && i!=j && cards[j]==wants[i]){
                    int tmp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = tmp;
                    sol(changed, cards, r+1, wants);
                }
            }
        }
    }
    private static int matchCards(int[] cards, int[] wants) {
        int tmp=0;
        for(int i=0;i<cards.length;i++){
            tmp = cards[i]!=wants[i] ? tmp+1 : tmp;
        }
        return tmp;
    }

   
}
