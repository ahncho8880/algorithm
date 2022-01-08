package sol;

import java.util.*;

public class DSLR {
	static class Resister {
		int val;
		int valInt;
		Resister(int val, int valInt){
			this.val = val;
			this.valInt = valInt;
		}
	}
	static int T, A, B;

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// T = sc.nextInt();
		// for(int i=0;i<T;i++){
		// 	A = sc.nextInt();
		// 	B = sc.nextInt();
		// 	calDSLR(A, B);
		// }
		// sc.close();
		calDSLR(0, 9998);
	}

	private static void calDSLR(int a, int b){
		Queue<Resister> q = new LinkedList<>();
		HashSet<Integer> hs = new HashSet<>();
		q.add(new Resister(a, 0));
		hs.add(a);
		while(!q.isEmpty()){
			Resister resister = q.poll();
			int n = resister.val;
			int nInt = resister.valInt;
			if(n == b){
				System.out.println(nInt);
				break;
			}
			//D
			int d = n * 2;
			d = d > 9999 ? d % 10000 : d;
			if(!hs.contains(d)){
				q.add(new Resister(d, 10*nInt + 1));
			}
			//S
			int s = n - 1;
			s = s == -1 ? 9999 : s;
			if(!hs.contains(s)){
				q.add(new Resister(s, 10*nInt + 2));
			}
			//L
			int l = turnL(n);
			if(!hs.contains(l)){
				q.add(new Resister(l, 10*nInt + 3));
			}
			//R
			int r = turnR(n);
			if(!hs.contains(r)){
				q.add(new Resister(r, 10*nInt + 4));
			}
		}
	}

	private static int turnL(int n){
		int[] arrayN = new int[4];
		int d = 1000;
		int num = 0;
		int temp = n;
		while(num<4){
			arrayN[num] = temp/d;
			temp -= arrayN[num++] * d;
			d /= 10;  
		}
		int tmp = arrayN[0];
		for(int i=0;i<4;i++){
			if(i==3){
				arrayN[i] = tmp;
			}else{
				arrayN[i] = arrayN[i+1];
			}
		}
		return combineN(arrayN);
	}

	private static int turnR(int n){
		int[] arrayN = new int[4];
		int d = 1000;
		int num = 0;
		int temp = n;
		while(num<4){
			arrayN[num] = temp/d;
			temp -= arrayN[num++] * d;
			d /= 10;  
		}
		int tmp = arrayN[3];
		for(int i=3;i>=0;i--){
			if(i==0){
				arrayN[i] = tmp;
			}else{
				arrayN[i] = arrayN[i-1];
			}
		}
		return combineN(arrayN);
	}

	private static int combineN(int[] arr){
		return  ((arr[0] * 10 + arr[1]) * 10 + arr[2]) * 10 + arr[3];
	}
}