package sol;

import java.util.*;

public class line_no3{
    public static void main(String[] args){
        int[] enter = {1,4,2,3};
        int[] leave = {2,1,3,4};

        solution(enter, leave);
    }
    public static void solution(int[] enter, int[] leave){
        System.out.println("pandemic");
        int n = enter.length;
        int m = enter.length;
        boolean[][] met = new boolean[n][m];
        int[] cur = new int[n];
        ArrayList<Integer> current = new ArrayList<Integer>();
        int count = 0;
        int countIn = 0;
        while(countIn < n){
            current.add(enter[countIn]);
            met[enter[countIn]-1][enter[countIn]-1] = true;
            for(int k=0;k<n;k++){
                for(int h=0;h<current.size();h++){
                    // if(!met[][]&&current.get(h)==k+1){

                    // }
                }
            }
            countIn++;
            
                System.out.println(current);
                for(int i=0;i<current.size();i++){
                    if(leave[count]==current.get(i)){
                        System.out.println(current+"-before");
                        current.remove(Integer.valueOf(leave[count]));
                        count++;
                        i=-1;
                    }
                }
        }
        for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            System.out.print(met[i][j]+" ");
        }
    System.out.println();
    }
    }
}