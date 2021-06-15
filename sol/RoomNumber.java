package sol;

import java.io.*;
import java.util.*;

public class RoomNumber{
	static String N;
	static int n;
	static boolean[] check;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.next();
		n = N.length();
		check = new boolean[n];
		int res = 0;
		while(!checkEnd()){
			boolean[] number = new boolean[10];
			for(int i=0;i<n;i++){
				int num = N.charAt(i)-'0';
				if(!number[num] && !check[i]){
					number[num] = true;
					check[i] = true;
				}else if(num == 6 && !number[9] && !check[i]){
					number[9] = true;
					check[i] = true;
				}else if(num == 9 && !number[6] && !check[i]){
					number[6] = true;
					check[i] = true;
				}
			}
			res++;
		}
		System.out.println(res);
	}

	public static boolean checkEnd(){
		for (boolean value : check) {
        	if (!value)
            	return false;
    	}
    	return true;
	}
}