package samsungSW;

import java.util.Scanner;

public class ExamObserver {
    static int N,B,C;
    static long ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        int[] students = new int[N];
        for(int i=0;i<N;i++){
            students[i] = sc.nextInt();
        }
        B = sc.nextInt();
        C = sc.nextInt();
        for(int student : students){
            student-=B;
            ans++;
            if(student>0)
                ans += student%C==0 ? student/C : (student/C)+1;
        }
        System.out.println(ans);
    }
}
