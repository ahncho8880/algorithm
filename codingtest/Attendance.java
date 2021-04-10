package codingtest;

import java.util.ArrayList;
import java.util.Arrays;

public class Attendance {
    public static void main(String[] args) {
        int[] enter = {1,3,2};
        int[] leave = {1,2,3};
        // int[] enter = {1,4,2,3};
        // int[] leave = {2,1,3,4};
        // int[] enter = {3,2,1};
        // int[] leave = {2,1,3};
        // int[] enter = {3,2,1};
        // int[] leave = {1,3,2};
        solution(enter, leave);
    }

    private static void solution(int[] enter, int[] leave) {
        int n = enter.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] ans = new int[n];
        int enterNo =0, leaveNo =0;
        while(enterNo!=n){
            while(!list.contains(leave[leaveNo])){
                list.add(enter[enterNo++]);
            }
            // System.out.println(list);
            ans = list.size() > 1 ? cal(list, ans) : ans;
            while(leaveNo!=n && list.contains(leave[leaveNo])){
                list.remove(Integer.valueOf(leave[leaveNo++]));
            }
        }
        System.out.println(Arrays.toString(ans));
    }
    private static int[] cal(ArrayList<Integer> list, int[] ans) {
        int size = list.size()-1;
        for(int i : list){
            ans[i-1]+=size;
        }
        return ans;
    }
    

}
