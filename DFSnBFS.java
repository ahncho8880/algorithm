import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSnBFS {
    static int N,M,V;
    static boolean[] visited;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N+1];
        graph = new int[N+1][N+1];
        for(int i=0;i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        dfs(V);
        for(int i : ans){
            System.out.print(i+" ");
        }
        System.out.println();
        ans.clear();
        Arrays.fill(visited, false);
        bfs(V);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
    private static void dfs(int v){
        visited[v] = true;
        ans.add(v);
        for(int i=1;i<N+1;i++){
            if(graph[v][i]==1 && !visited[i]){
                dfs(i);
            }
        }
    }
    private static void bfs(int v){
        Queue<Integer> queue  = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(int i=1;i<N+1;i++){
                if(graph[node][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}