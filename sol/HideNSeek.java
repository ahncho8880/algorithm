package sol;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideNSeek {
    static int N;
    static int K;
    static int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Arrays.fill(visited, -1);
        findBro(N);
        sc.close();
    }

    private static void findBro(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 0;
        int position = 0;
        while(!q.isEmpty()){
            position = q.poll();
            if(position == K) break;
            if(position + 1 <= 100000 && visited[position + 1] == -1){
                visited[position + 1] = visited[position] + 1;
                q.add(position + 1);
            }
            if(position - 1 >= 0 && visited[position - 1] == -1){
                visited[position - 1] = visited[position] + 1;
                q.add(position - 1);
            }
            if(position * 2 <= 100000 && visited[position * 2] == -1){
                visited[position * 2] = visited[position] + 1;
                q.add(position * 2);
            }
        }
        System.out.println(visited[position]);
    }
}
