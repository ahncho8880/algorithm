package samsungSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Wheels {
    static String[][] wheelTools = new String[4][8];
    static int K, ANS = 0;
    static ArrayList<ArrayList<Integer>> infos = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<4;i++){
            wheelTools[i] = br.readLine().split("");
        }
        K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> info = new ArrayList<>();
            info.add(Integer.parseInt(st.nextToken())-1);
            info.add(Integer.parseInt(st.nextToken()));
            infos.add(info);
        }
        for(ArrayList<Integer> arr : infos){
            boolean[] visited = new boolean[4];
            turnWheels(arr.get(0), arr.get(1), 0, 1, visited);
        }
        for(int i=0;i<wheelTools.length;i++){
            ANS+= Integer.parseInt(wheelTools[i][0])==1 ? (int) Math.pow(2, i) : 0;   
        }
        bw.write(ANS);
        System.out.println(bw);
        bw.close();
    }
    private static void turnWheels(int num, int direction ,int left, int right, boolean[] visited) {
        if(left+right==1 && !visited[num]){
            left = Integer.parseInt(wheelTools[num][6]);
            right = Integer.parseInt(wheelTools[num][2]);
            if(direction==1){
                turnClock(num);
            }else{
                turnReverse(num);
            }
            direction = direction==1 ? -1 : 1;
            visited[num] = true;
            //left
            if(num>0 && num<4){
                turnWheels(num-1, direction, left, Integer.parseInt(wheelTools[num-1][2]), visited);
            }
            //right
            if(num>=0 && num<3){
                turnWheels(num+1, direction, Integer.parseInt(wheelTools[num+1][6]), right, visited);
            }
        }else{
            return;
        }
    }
    private static void turnClock(int num) {
        String temp = wheelTools[num][7];
        for(int i=7;i>=1;i--){
            wheelTools[num][i] = wheelTools[num][i-1];
        }
        wheelTools[num][0] = temp;
    }
    private static void turnReverse(int num) {
        String temp = wheelTools[num][0];
        for(int i=0;i<7;i++){
            wheelTools[num][i] = wheelTools[num][i+1];
        }
        wheelTools[num][7] = temp;
    }
}