package sol;

import java.util.*;

public class LinkElement{
	static int N;
	static int M;
	static int[] pair;
	static ArrayList<int[]> linkList = new ArrayList<>();
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i=0;i<M;i++){
			pair = new int[2];
			pair[0] = sc.nextInt();
			pair[1] = sc.nextInt();
			linkList.add(pair);
		}
		sc.close();
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++){
			answer += countLink(i) ? 1 : 0;
		}
		System.out.print(answer);
	}	

	public static boolean countLink(int number){
		if(visited[number]){
			return false;
		}
		visited[number] = true;
		for(int i=0;i<M;i++){
			int mate = 0;
			if(linkList.get(i)[0]==number){
				mate = linkList.get(i)[1];
				countLink(mate);
			}
			else if(linkList.get(i)[1]==number){
				mate = linkList.get(i)[0];
				countLink(mate);
			}
		}
		return true;
	}
}