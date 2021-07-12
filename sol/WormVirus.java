package sol;
import java.util.*;

public class WormVirus{
	static int N;
	static int n;
	static int[] pair;
	static ArrayList<int[]> computer = new ArrayList<>();
	static boolean[] visited;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		n = sc.nextInt();
		visited = new boolean[N+1];
		for(int i=0;i<n;i++){
			pair = new int[2];
			pair[0] = sc.nextInt();
			pair[1] = sc.nextInt();
			computer.add(pair);
		}
		searchVirus(1);
		System.out.println(answer);
	}

	public static void searchVirus(int virus){
		if(visited[virus]){
			return;
		}
		answer++;
		visited[virus] = true;
		for(int i=0;i<n;i++){
			if(computer.get(i)[0] == virus){
				searchVirus(computer.get(i)[1]);
			}
			else if(computer.get(i)[1] == virus){
				searchVirus(computer.get(i)[0]);
			}
		}
	}
}