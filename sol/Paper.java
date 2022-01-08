package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Paper {
    static int N;
    static int map[][];
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            String[] strArr = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        dividePaper(map);
        System.out.println(white+"\n"+blue);
    }

    public static void dividePaper(int[][] parts){
        int color = paintOneZero(parts);
        if(color!=-1){
            white += color == 0 ? 1 : 0;
            blue += color == 1 ? 1 : 0;
            return;
        }
        int[][] part1 = new int[parts.length/2][parts.length/2];
        int[][] part2 = new int[parts.length/2][parts.length/2];
        int[][] part3 = new int[parts.length/2][parts.length/2];
        int[][] part4 = new int[parts.length/2][parts.length/2];
        int x1=0, y1=0;
        int x2=0, y2=0;
        int x3=0, y3=0;
        int x4=0, y4=0;
        for(int i=0;i<parts.length;i++){
            for(int j=0;j<parts.length;j++){
                if(i < parts.length/2 && j < parts.length/2){
                    part1[x1][y1++] = parts[i][j];
                }
                else if(i < parts.length/2 && j >= parts.length/2){
                    part2[x2][y2++] = parts[i][j];
                }
                else if(i >= parts.length/2 && j < parts.length/2){
                    part3[x3][y3++] = parts[i][j];
                }
                else if(i >= parts.length/2 && j >= parts.length/2){
                    part4[x4][y4++] = parts[i][j];
                }
            }
            if(y1!=0){
                x1++;
                y1=0;
            }
            if(y2!=0){
                x2++;
                y2=0;
            }
            if(y3!=0){
                x3++;
                y3=0;
            }
            if(y4!=0){
                x4++;
                y4=0;
            }
        }
        dividePaper(part1);
        dividePaper(part2);
        dividePaper(part3);
        dividePaper(part4);
    }

    public static int paintOneZero(int[][] parts){
        int color = parts[0][0];
        for(int i=0;i<parts.length;i++){
            for(int j=0;j<parts.length;j++){
                if(color!=parts[i][j]){
                    return -1;
                }
            }   
        }
        return color;
    }
}
