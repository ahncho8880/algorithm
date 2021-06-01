import java.util.*;

public class AntarcticaWord{
	static int N,K;
	static String[] word;
	// static char[] antatica = {'a','n','t','i','c'};
	static HashSet<Character> antatica = new HashSet<>();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		word = new String[N];
		for(int i=0;i<N;i++){
			String temp = sc.next();
			word[i] = temp.substring(4,temp.length()-4);
		}
		antatica.add('a');
		antatica.add('n');
		antatica.add('t');
		antatica.add('i');
		antatica.add('c');
		if(K>=5){
			dfs(K-5);
		}
	}
		public static void dfs(int r){
			int length = word.length();
			System.out.println(word);
			for(int i=0;i<length;i++){
				char c = word.charAt(i);
				if(!antatica.contains(c)){
					
				}
			}
		}
}
