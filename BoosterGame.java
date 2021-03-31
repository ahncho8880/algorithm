import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BoosterGame {
    static int N, Q, X;
    static boolean[] check;
    static boolean isYes = false;
    public static class Node{
        int x;
        int y;
        int hp;
        public Node(int x, int y, int hp){
            this.x = x;
            this.y = y;
            this.hp = hp;
        }

        public void toString(int x, int y, int hp){
            System.out.println(x+", "+y+", "+hp);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        Q = input.nextInt();
        int[][] checkpoint = new int[N][2];
        int[][] quest = new int[Q][3];
        for(int i=0;i<checkpoint.length;i++){
            checkpoint[i][0] = input.nextInt();
            checkpoint[i][1] = input.nextInt();
        }
        for(int i=0;i<quest.length;i++){
            quest[i][0] = input.nextInt();
            quest[i][1] = input.nextInt();
            quest[i][2] = input.nextInt();
        }
        for(int i=0;i<quest.length;i++){
            boolean[] visited = new boolean[N];
            check = visited;
            int start_x  = checkpoint[quest[i][0]-1][0];
            int start_y = checkpoint[quest[i][0]-1][1];
            int hp = quest[i][2];
            int goal_x  = checkpoint[quest[i][1]-1][0];
            int goal_y = checkpoint[quest[i][1]-1][1];
            boolean isYes = false;
            Queue<Node> pq = new LinkedList<>();
            pq.add(new Node(start_x, start_y, hp));
            visited[quest[i][0]-1] = true;
            while(!pq.isEmpty()){
                Node nd = pq.poll();
                // nd.toString(nd.x, nd.y, nd.hp);
                if(nd.x==goal_x && nd.y ==goal_y){
                    isYes = true;
                    break;
                }
                for(int j=0;j<checkpoint.length;j++){
                    if(checkpoint[j][0]==nd.x && !visited[j]){
                        visited[j] = true;
                        pq.add(new Node(nd.x, checkpoint[j][1], hp));
                    }
                    if(checkpoint[j][1]==nd.y && !visited[j]){
                        visited[j] = true;
                        pq.add(new Node(checkpoint[j][0], nd.y, hp));
                    }
                }
                if(nd.hp>0){
                    pq.add(new Node(nd.x+1, nd.y, nd.hp-1));
                    pq.add(new Node(nd.x-1, nd.y, nd.hp-1));
                    pq.add(new Node(nd.x, nd.y+1, nd.hp-1));
                    pq.add(new Node(nd.x, nd.y-1, nd.hp-1));
                }
            }   
            System.out.println(isYes ? "YES" : "NO"); 
        }
    }
}
