package sol;

import java.util.Scanner;
public class Bomballon {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] nums = new int[N];
        boolean[] bombed = new boolean[N];
        for(int i=0;i<N;i++){
            nums[i] = sc.nextInt();
        }
        bombed[0] = true;
        seq(nums, bombed, 0, N-1);
    }
    private static void seq(int[] nums, boolean[] bombed, int i, int n) {
        System.out.print(i+1+" ");
        if(n==0){
            return;
        }
        int count = nums[i];    
        int k=i;
        while(count!=0){
            if(count>0){
                k++;
                if(k==N)
                    k=0;
                if(!bombed[k]){
                    count--;
                }
            }else{
                k--;
                if(k==-1)
                    k=N-1;
                if(!bombed[k]){
                    count++;
                }
            }
        }
        bombed[k]= true;
        seq(nums, bombed, k, n-1);
    }
}
