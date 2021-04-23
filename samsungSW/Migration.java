package samsungSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Migration {
	static int N, L, R;
	static int sum = 0, union = 0, ANS = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[][] teams;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> unionPop = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		teams = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer li = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(li.nextToken());
			}
		}
		boolean isTrue = true;
		int team = 0;
		while (isTrue) {
			team = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						openBorder(i, j, team++);
						unionPop.add(sum / union);
						sum = 0;
						union = 0;
					}
				}
			}
			setPopulation();
			isTrue = team != (N * N);
			ANS++;
		}
		bw.write(ANS - 1 + "\n");
		bw.close();
	}

	private static void setPopulation() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = unionPop.get(teams[i][j]);
				visited[i][j] = false;
			}
		}
		unionPop.clear();
	}

	private static void openBorder(int x, int y, int team) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		visited[x][y] = true;
		teams[x][y] = team;
		sum += map[x][y];
		union += 1;
		for (int i = 0; i < 4; i++) {
			if (isOpen(x, y, x + dx[i], y + dy[i])) {
				openBorder(x + dx[i], y + dy[i], team);
			}
		}
	}

	private static boolean isOpen(int x, int y, int dx, int dy) {
		if (dx == N || dx == -1 || dy == N || dy == -1 || visited[dx][dy]) {
			return false;
		}
		int a = map[x][y];
		int b = map[dx][dy];
		int sub = Math.abs(a - b);
		return sub >= L && sub <= R;
	}
}
