package samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ChickenDelivery {
    static int N, M, ANS=999999999, storeNo=0;
    static int[][] map;
    static ArrayList<int[]> houses = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer li = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(li.nextToken());
                storeNo += map[i][j]==2 ? 1 : 0;
                if(map[i][j]==1){
                    int[] tmp = {i,j};
                    houses.add(tmp);
                }
            }
        }
        calChicken(0, 0, storeNo-M);
        System.out.println(ANS);
    }
    private static void calChicken(int s, int s2, int r){
        if(r==0){
            int[][] tempMap = new int[N][N];
            copyMap(tempMap);
            int min = calDistance(tempMap);
            ANS = min < ANS ? min : ANS;
            return;
        }
        for(int i=s;i<N;i++){
            for(int j=s2;j<N;j++){
                if(map[i][j]==2){
                    map[i][j] = 0;
                    calChicken(i,j+1,r-1);
                    map[i][j] = 2;
                }
            }
            s2=0;
        }
    }
    private static int calDistance(int[][] tempMap) {
        int sum = 0;
        for(int i=0;i<houses.size();i++){
            int x = houses.get(i).clone()[0], y = houses.get(i).clone()[1], distance=999999999;
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(tempMap[j][k]==2){
                        int tmpDistance = Math.abs(x-j)+Math.abs(y-k);
                        distance= distance > tmpDistance ? tmpDistance : distance;
                    }
                }
            }
            sum+=distance;
        }
        return sum;
    }
    private static void copyMap(int[][] tempMap) {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                tempMap[i][j] = map[i][j];
            }
        }
    }
}