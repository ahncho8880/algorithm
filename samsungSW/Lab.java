package samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lab {
    static int N, M, MAX=0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(line.nextToken());
            }
        }
        setWall(3, 0, 0);
        System.out.println(MAX);
    }
    private static void setWall(int r, int s, int restart) {
        if(r==0){
            int[][] copyMap = new int[N][M];
            copyArray(copyMap);
            setPandemic(copyMap);
            int temp = countZero(copyMap);
            MAX = MAX<temp ? temp : MAX;
            return;
        }

        for(int i=s;i<N;i++){
            for(int j=restart;j<M;j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    setWall(r-1, i, j+1);
                    map[i][j] = 0;
                }
            }
            restart=0;
        }
    }
    private static void copyArray(int[][] copyMap) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copyMap[i][j] = map[i][j];  
            }
        }
    }
    private static int countZero(int[][] tempMap) {
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                cnt += tempMap[i][j]==0 ? 1 : 0;
            }
        }
        return cnt;
    }
    private static void setPandemic(int[][] panMap) {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(panMap[i][j]==2){
                    setVirus(i, j, panMap);
                }
            }
        }
    }
    private static void setVirus(int i, int j, int[][] panMap) {
        int[] x ={1,-1,0,0};
        int[] y ={0,0,1,-1};
        for(int k=0;k<4;k++){
            int tmpX = i+x[k];
            int tmpY = j+y[k];
            if(tmpX < N && tmpX >= 0 && tmpY < M && tmpY >= 0 && panMap[tmpX][tmpY] == 0){
                panMap[tmpX][tmpY] = 2;
                setVirus(tmpX, tmpY, panMap);
            }
        }
    }  
}
