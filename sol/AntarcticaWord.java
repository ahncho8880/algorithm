//1062
package sol;

import java.util.*;

public class AntarcticaWord{
	static int N, K;
	static String[] words;
	static int newWordSize;
	static int ans = 0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		words = new String[N];
		for(int i=0;i<N;i++){
			String temp = sc.next();
			words[i] = temp.substring(4,temp.length()-4);
		}
		sc.close();
		HashSet<Character> antatica = new HashSet<>();
		ArrayList<Character> newWords = new ArrayList<>();
		antatica.add('a');
		antatica.add('n');
		antatica.add('t');
		antatica.add('i');
		antatica.add('c');
		if(K>=5){
			getNewWord(newWords, antatica);
			selectWord(newWords, antatica, K-5, 0, 0);
		}
		System.out.println(ans);
	}
	
	private static void getNewWord(ArrayList<Character> newWords, HashSet<Character> antatica) {
		for(int i=0;i<words.length;i++){
			for(int j=0;j<words[i].length();j++){
				if(!newWords.contains(words[i].charAt(j)) && !antatica.contains(words[i].charAt(j))){
					newWords.add(words[i].charAt(j));
				}
			}
		}
		newWordSize = newWords.size();
	}

	public static void selectWord(ArrayList<Character> newWords, HashSet<Character> antatica, int r, int num, int lim){
		if(r==0 || lim==newWordSize){
			// System.out.println(antatica);
			int count = 0;
			for(int i=0;i<words.length;i++){
				count += isRead(antatica, words[i]) ? 1 : 0;
			}
			ans = Math.max(ans, count);
			return;
		}
		for(int i=num;i<newWords.size();i++){
			antatica.add(newWords.get(i));
			selectWord(newWords, antatica, r - 1, i+1, lim + 1);
			antatica.remove(newWords.get(i));
		}
	}

	private static boolean isRead(HashSet<Character> antatica, String str) {
		for(int i=0;i<str.length();i++){
			if(!antatica.contains(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
}
