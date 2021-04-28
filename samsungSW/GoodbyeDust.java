package samsungSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GoodbyeDust {
	static int R, C, T;
	static int ans = 0;
	static int[][] map;
	static int[][] tempMap;
	static int[] dR = {-1, 0, 1, 0};
	static int[] dC = {0, 1, 0, -1};
	static int[][] directionX = {{-1, 0, 1, 0}, {1, 0, -1, 0}};
	static int[][] directionY = {{0, 1, 0, -1}, {0, 1, 0, -1}};
	static ArrayList<int[]> airCleaner = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		tempMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			StringTokenizer li = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(li.nextToken());
				tempMap[i][j] = 0;
				if (map[i][j] == -1) {
					tempMap[i][j] = -1;
					airCleaner.add(new int[] {i, j});
				}
			}
		}
		for (int i = 0; i < T; i++) {
			spreadDust();
			cleanAir();
			setMap();
		}
		addDust();
		bw.write(ans + "\n");
		bw.close();
	}

	private static void moveDust(int r, int c, int d) {
		int num = 0;
		int[][] terms = {{-1, airCleaner.get(0).clone()[0] + 1, -1, C}, {R, airCleaner.get(1).clone()[0] - 1, -1, C}};
		while (num < 4) {
			int dX = r + directionX[d][num];
			int dY = c + directionY[d][num];
			if (dX == terms[d][0] || dX == terms[d][1] || dY == terms[d][2] || dY == terms[d][3]) {
				num += 1;
			} else {
				tempMap[r][c] = tempMap[dX][dY];
				r = dX;
				c = dY;
			}
		}
		tempMap[r][1] = 0;
		tempMap[r][0] = -1;
	}

	private static void cleanAir() {
		for (int i = 0; i < airCleaner.size(); i++) {
			int r = airCleaner.get(i).clone()[0];
			int c = airCleaner.get(i).clone()[1];
			moveDust(r, c, i);
		}
	}

	private static void addDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					ans += map[i][j];
			}
		}
	}

	private static void setMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = tempMap[i][j];
				tempMap[i][j] = map[i][j] == -1 ? -1 : 0;
			}
		}
	}

	private static void spreadDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					int oneFifth = map[i][j] / 5;
					int temp = tempMap[i][j];
					tempMap[i][j] = map[i][j];
					for (int k = 0; k < 4; k++) {
						tempMap[i][j] -= isSpread(i + dR[k], j + dC[k], oneFifth) ? oneFifth : 0;
					}
					tempMap[i][j] += temp;
				}
			}
		}
	}

	private static boolean isSpread(int r, int c, int dust) {
		if (r == -1 || c == -1 || r == R || c == C || map[r][c] == -1) {
			return false;
		}
		tempMap[r][c] += dust;
		return true;
	}
}
