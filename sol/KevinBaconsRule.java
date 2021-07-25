package sol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KevinBaconsRule {
    static int N;
    static int M;
    static class Node {
        int count;
        int number;
        Node(int count, int number){
            this.count = count;
            this.number = number;
        }
    }
    static int[][] web;
    static int min = Integer.MAX_VALUE;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        web = new int[M][2];
        for(int i=0;i<M;i++){
            web[i][0] = sc.nextInt();
            web[i][1] = sc.nextInt();
        }
        sc.close();
        for(int i=1;i<=N;i++){
            generateKevinbacon(i);
        }
        System.out.println(ans);
    }

    private static void generateKevinbacon(int cur) {
        int sum = 0;
        for(int i=1;i<=N;i++){
            if(cur != i){
                boolean[] visited = new boolean[N+1];
                Queue<Node> q = new LinkedList<>();
                q.add(new Node(0, cur));
                visited[cur] = true;
                while(!q.isEmpty()){
                    Node node = q.poll();
                    int count = node.count;
                    int number = node.number;
                    if(number == i){
                        sum += count;
                        break;
                    }
                    for(int j=0;j<M;j++){
                        if(web[j][0] == number && !visited[web[j][1]]){
                            q.add(new Node(count + 1, web[j][1]));
                            visited[web[j][1]] = true;
                        }
                        else if(web[j][1] == number && !visited[web[j][0]]){
                            q.add(new Node(count + 1, web[j][0]));
                            visited[web[j][0]] = true;
                        }
                    }
                }
            }
        }
        if(sum < min){
            ans = cur;
            min = sum;
        }
    }
}