package sol;

import java.util.Scanner;

public class Stairs{
	static int N;
	static int[] points;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		points = new int[N+1];
		points[0] = 0;
		for(int i=1;i<=N;i++){
			points[i] = sc.nextInt();
		}
		sc.close();
		goUpStairs(1, 0, 0);
		goUpStairs(2, 0, 0);
		System.out.println(max);
	}

	public static void goUpStairs(int floor, int count, int sum) {
		if(count==2 || floor > N){
			return;
		}
		if(floor == N){
			sum += points[floor];
			max = Math.max(max, sum);
			return;
		}
		goUpStairs(floor+1, count+1, sum+points[floor]);
		goUpStairs(floor+2, 0, sum+points[floor]);
	}
}