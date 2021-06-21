//1002
package sol;

import java.util.*;

public class Turret {
	static int T;
	static Scanner sc;

	public static void main(String[] args){
		sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0;i<T;i++){
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			double n = (double) Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
			int maxR = Math.max(r1,r2);
			int minR = Math.min(r1,r2);
			if(n < maxR){
				if(n==0 && n == maxR-minR){
					System.out.println("-1");
				} else if(n <  maxR-minR){
					System.out.println("0");
				} else if(n >  maxR-minR){
					System.out.println("2");
				} else if(n == maxR-minR){
					System.out.println("1");
				}
			}
			if(n > maxR){
				if(n > r1+r2){
					System.out.println("0");
				} else if(n == r1+r2){
					System.out.println("1");
				} else if(n < r1+r2){
					System.out.println("2");
				}
			}
			if(n==maxR){
				System.out.println("2");
			}
		}
	}
}