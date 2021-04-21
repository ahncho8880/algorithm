package samsungSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Dyson {
    static int N, M, r, c, d;
    static int[][] map;
    static boolean[][] cleaned;
    static int ANS = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringTokenizer li = new StringTokenizer(br.readLine());
        r = Integer.parseInt(li.nextToken());
        c = Integer.parseInt(li.nextToken());
        d = Integer.parseInt(li.nextToken());
        map = new int[N][M];
        cleaned = new boolean[N][M];
        for(int i=0;i<N;i++){
            StringTokenizer li2 = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(li2.nextToken());
            }
        }
        cleanRoom(r,c,d,0);
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(cleaned[i][j])
                    ANS++;
            }
        }
        bw.write(ANS+"\n");
        bw.close();
    }
    private static void cleanRoom(int x, int y, int direction, int count) {
        cleaned[x][y] = true;
        int dx = x, dy = y;
        if(count==4){
            if(direction==0){           //north
                dx+=1;
            }else if(direction==1){     //east
                dy-=1;
            }else if(direction==2){     //south
                dx-=1;
            }else if(direction==3){     //west
                dy+=1;
            }
            if(map[dx][dy]==1){
                return;
            }
            cleanRoom(dx, dy, direction, 0);
        }else{
            if(direction==0){           //north
                direction = 3;
                dy-=1;
            }else if(direction==1){     //east
                direction = 0;
                dx-=1;
            }else if(direction==2){     //south
                direction = 1;
                dy+=1;
            }else if(direction==3){     //west
                direction = 2;
                dx+=1;
            }
            if(map[dx][dy]==1 || cleaned[dx][dy]){
                cleanRoom(x, y, direction, count+1);
            }else{
                cleanRoom(dx, dy, direction, 0);
            }
        }
    }
}
