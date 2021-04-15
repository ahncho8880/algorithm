package codingtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PassengerAndTrain {
    public static void main(String[] args) {
        int n=5;
        int[] passenger = {1,1,2,3,4};
        int[][] train = {{1,2},{1,3},{1,4},{1,5}};
        solution(n, passenger, train);
    }
    public static class Node{
        boolean[] before;
        int pass;
        int current;
        
        public Node(boolean[] before, int pass, int current){
            this.before = before;
            this.pass = pass;
            this.current = current;
        }
    }
    public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {};
        answer = pass(1, passenger, train, n);
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public static int[] pass(int start, int[] pass, int[][] train, int n){
        Queue<Node> pq = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        pq.add(new Node(visited, pass[start-1], start));
        int[] ans = new int[2];
        while(!pq.isEmpty()){
            Node node = pq.poll();
            boolean[] vis = node.before;
            int cur = node.current;
            int cnt = node.pass;
            int no =0;

            for(int i=0;i<train.length;i++){
                if(train[i][0]==cur && !vis[train[i][1]-1]){
                    vis[train[i][1]-1] = true;
                    pq.add(new Node(vis, cnt+pass[train[i][1]-1], train[i][1]));
                    vis[train[i][1]-1] = true;
                }else if(train[i][1]==cur && !vis[train[i][0]-1]){
                    vis[train[i][0]-1] = true;
                    pq.add(new Node(vis, cnt+pass[train[i][0]-1], train[i][0]));
                    vis[train[i][0]-1] = true;
                }else{
                    no++;
                }
            }

            if(no==train.length){
                ans[0] = cur;
                ans[1] = cnt;
            }
        }
        return ans;
    }
}
