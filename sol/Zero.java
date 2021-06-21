package sol;

import java.util.*;

public class Zero{
	static int K;
	static Scanner sc;
	static ArrayList<Integer> list;
	static int res=0;
	
	public static void main(String[] args){
		sc = new Scanner(System.in);
		K = sc.nextInt();
		list = new ArrayList<>();
		for(int i=0;i<K;i++){
			int number = sc.nextInt();
			if(number!=0){
				list.add(number);
			}else{
				int n = list.size()-1;
				list.remove(n);
			}
		}

		for(int i : list){
			res += i;
		}
		System.out.println(res);
	}	
}