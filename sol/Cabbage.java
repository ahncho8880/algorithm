//1012
package sol;

import java.util.Arrays;
import java.util.Scanner;

public class Cabbage {
    static Scanner sc;
    static int T, M, N, K;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int i=0;i<T;i++){
            M = sc.nextInt();
            N = sc.nextInt();
            map = new int[M][N];
            for(int j=0;j<M;j++){
                Arrays.fill(map[j], 0);
            }
            K = sc.nextInt();
            for(int j=0;j<K;j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }
            int res = searchMap();
            System.out.println(res);
        }
    }

    private static int searchMap() {
        int count = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1){
                    searchBlock(i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private static void searchBlock(int x, int y) {
        if(x==M || y==N || x==-1 || y==-1 || map[x][y] != 1){
            return;
        }
        map[x][y] = 0;
        searchBlock(x+1, y);
        searchBlock(x-1, y);
        searchBlock(x, y+1);
        searchBlock(x, y-1);
    }
}
