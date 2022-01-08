package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Card2 {
    static int N;
    static Queue<Integer> cards = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++){
            cards.add(i);
        }
        while(!cards.isEmpty()){
            if(cards.size()==1){
                System.out.println(cards.peek());
                break;
            }
            cards.poll();
            cards.add(cards.poll());
        }
    }
}
