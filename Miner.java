import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Miner {
    public static class Node{
        int x;
        int y;
        int v;

        public Node(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    static public int ANS = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        C = sc.nextInt();
        int minerals[][] = new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                minerals[i][j] = sc.nextInt();
            }
            int x = minerals[i][0];
            int y = minerals[i][1];
            int v = minerals[i][2];
            X.add(new Node(x, y, v));
            Y.add(new Node(x, y, v));
        }
        sc.nextLine();
        int min = 10000;
        
        solution(n, C, minerals);
        // dfs();
    }
    
    
    private static void del(int y, int x) {
        for (Node node : Y) {
            System.out.println(node.x+" "+x);
            if (node.x <= x) {
                cnt--;
                V -= node.v;
            }
        }
    }
    
    private static void add(int x, int y) {
        for (Node node : X) {
            if (node.y <= y) {
                cnt++;
                V += node.v;
            }
        }
    }

    static int W = -1, H = 11, cnt = 0;
    static long V = 0, ans = 0;
    static int n, C;
    static int NM = 10005;
    // static Node[] X = new Node[NM];
    // static Node[] Y = new Node[NM];
    static ArrayList<Node> X = new ArrayList<>();
    static ArrayList<Node> Y = new ArrayList<>();

    private static void dfs() {
        ans = V;
        while (W <= 100000 && H >= 0) {
            // System.out.println("W: "+W);
            // System.out.println("H: "+H);
            // System.out.println("cnt: "+cnt);
            if (cnt > C) {
                del(H--, W);
            }
            else {
                add(++W, H);
            }
            if (cnt <= C) {
                ans = ans < V ? V : ans;
            }
        }
        System.out.println(ans);
    }

    private static int solution(int n, int c, int[][] minerals) {
        boolean[] visited = new boolean[n];
        backtracking(minerals, visited, 0, c);
        System.out.println(ANS);
        return ANS;
    }

    private static void backtracking(int[][] minerals, boolean[] visited, int start, int c) {
        if(c==0){
            int tmp = calRect(minerals, visited);
            ANS = tmp > ANS && tmp != -1? tmp : ANS;
            return;
        }
        for(int i=start;i<visited.length;i++){
            visited[i] = true;
            backtracking(minerals, visited, i+1, c-1);
            visited[i] = false;
        }
    }

    private static int calRect(int[][] minerals, boolean[] visited) {
        int maxX = 0, maxY = 0, max = 0;
        for(int i=0;i<visited.length;i++){
            if(visited[i]){
                if(minerals[i][0]>maxX)
                    maxX = minerals[i][0];
                if(minerals[i][1]>maxY)
                    maxY = minerals[i][1];
                max += minerals[i][2];
            }
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i] && (minerals[i][0] <= maxX && minerals[i][1] <= maxY))
                return -1;
        }
        System.out.println(Arrays.toString(visited));
        return max;
    }

}