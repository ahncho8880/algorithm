package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ColorBlind {
    static int N;
    static char[][] map;
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int norAns = 0;
    static int unNorAns = 0;
    
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j);
            }
            System.out.println(Arrays.toString(map[i]));
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                observeNormalEyes(i, j, map[i][j], true);
                observeUnnormalEyes(i, j, map[i][j], true);
            }
        }
        System.out.println(norAns+" "+unNorAns);
    }

    private static void observeUnnormalEyes(int x, int y, char color, boolean isIn) {
        if(x<0 || x>=N || y<0 || y>=N  || visited2[x][y]){
            return;
        }
        if(color=='R' && map[x][y] =='B'){
            return;
        }
        if(color=='G' && map[x][y] =='B'){
            return;
        }
        if(color=='B' && color!=map[x][y]){
            return;
        }
        visited2[x][y] = true;
        unNorAns += isIn ? 1 : 0;
        observeUnnormalEyes(x + 1, y, color, false);
        observeUnnormalEyes(x - 1, y, color, false);
        observeUnnormalEyes(x, y + 1, color, false);
        observeUnnormalEyes(x, y - 1, color, false);
    }

    private static void observeNormalEyes(int x, int y, char color, boolean isIn) {
        if(x<0 || x>=N || y<0 || y>=N || color != map[x][y] || visited1[x][y]){
            return;
        }
        visited1[x][y] = true;
        norAns += isIn ? 1 : 0;
        observeNormalEyes(x + 1, y, color, false);
        observeNormalEyes(x - 1, y, color, false);
        observeNormalEyes(x, y + 1, color, false);
        observeNormalEyes(x, y - 1, color, false);
    }
}
