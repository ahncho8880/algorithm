package samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Watcher {
	static int N, M;
	static int[][] office;
	static int[][] observed;
	static ArrayList<int[]> camera = new ArrayList<>();
	static int[] pair;
	static int[] dR = {1, 0, -1, 0};
	static int[] dC = {0, 1, 0, -1};
	static int ANS = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		observed = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer li = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(li.nextToken());
				if (office[i][j] > 0 && office[i][j] <= 6) {
					pair = new int[] {i, j};
					camera.add(pair);
					observed[i][j] = 1;
				}
			}
		}
		dfs(observed, 0);
		System.out.println(ANS);

	}

	private static void setMin(int[][] o) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				count += o[i][j] == 0 ? 1 : 0;
			}
		}
		ANS = Math.min(ANS, count);
	}

	private static void dfs(int[][] ob, int num) {
		if (camera.size() == num) {
			setMin(ob);
			return;
		}
		int r = camera.get(num).clone()[0];
		int c = camera.get(num).clone()[1];
		int type = office[r][c];
		for (int i = 0; i < 4; i++) {
			selectCamera(ob, type, r, c, i, true);
			dfs(ob, num + 1);
			selectCamera(ob, type, r, c, i, false);
			if (type == 5)
				break;
		}

	}

	private static void selectCamera(int[][] ob, int type, int r, int c, int d, boolean b) {
		if (type == 1) {
			scanZone(ob, r, c, d, b);
		} else if (type == 2) {
			for (int i = 0; i < 4; i++) {
				if (i % 2 == d) {
					scanZone(ob, r, c, i, b);
				}
			}
		} else if (type == 3) {
			for (int i = 0; i < 4; i++) {
				if (i == d)
					scanZone(ob, r, c, i, b);
				if (i == d + 1)
					scanZone(ob, r, c, i, b);
			}
			if (d + 1 == 4)
				scanZone(ob, r, c, 0, b);
		} else if (type == 4) {
			for (int i = 0; i < 4; i++) {
				if (i == d)
					scanZone(ob, r, c, i, b);
				if (i % 2 != d % 2)
					scanZone(ob, r, c, i, b);
			}
		} else if (type == 5) {
			for (int i = 0; i < 4; i++) {
				scanZone(ob, r, c, i, b);
			}
		}
	}

	private static void scanZone(int[][] ob, int r, int c, int d, boolean b) {
		while (true) {
			r = r + dR[d];
			c = c + dC[d];
			if (r == -1 || r == N || c == -1 || c == M || office[r][c] == 6) {
				break;
			}
			ob[r][c] += b ? 1 : -1;
		}
	}
}
