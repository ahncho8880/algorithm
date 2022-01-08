package sol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class AC {
	static int T;
	static String[] p;
	static String[][] testCase;
	static String[] ans;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		p = new String[T];
		ans = new String[T];
		int n;
		ArrayList<String> list;
		for (int i = 0; i < T; i++) {
			p[i] = br.readLine();
			n = Integer.parseInt(br.readLine());
			list = getList(br.readLine());
			generateAC(p[i], list, n);
		}
	}

	public static ArrayList<String> getList(String sb){
		String res = sb.substring(1, sb.length()-1);
		return new ArrayList<>(Arrays.asList(res.split(",")));
	}

	public static void generateAC(String commands, ArrayList<String> testCase, int n){
		int cur = 0;
		int length = commands.length();
		while(cur < length) {
			char command = commands.charAt(cur);
			if(n==0 || testCase.size()==0 && command=='D'){
				System.out.println("error");
				break;
			}
			if(command =='R'){
				Collections.reverse(testCase);
			}
			if(command =='D'){
				testCase.remove(0);
			}
			cur++;
		}
		if(cur==length){
			System.out.println(testCase);
			return;
		}
	}
}
