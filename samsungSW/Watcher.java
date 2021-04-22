package samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Watcher {
    static int N, M;
    static int[][] office;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        for(int i=0;i<N;i++){
            StringTokenizer li = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                office[i][j] = Integer.parseInt(li.nextToken()); 
            }
        }

    }
}
