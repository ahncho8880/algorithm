import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AC {
	static int T, n;
	static String[] p;
	static String[] temp;
	static ArrayList<String[]> test = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		p = new String[T];
		for (int i = 0; i < T; i++) {
			p[i] = br.readLine();
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

			temp = br.readLine().replaceAll("[^0-9]", " ").trim().split(" ");
			test.add(temp);
		}
		for (int i = 0; i < T; i++) {
			doCommand(p[i], test.get(i));
		}
		bw.close();
	}

	private static void doCommand(String com, String[] c) throws IOException {
		for (int i = 0; i < com.length(); i++) {
			if (c.length == 0) {
				break;
			}
			if (com.charAt(i) == 'R') {
				c = reverse(c);
			} else if (com.charAt(i) == 'D') {
				c = delete(c);
			}
		}
		printAns(c);
	}

	private static String[] delete(String[] c) {
		int len = c.length - 1;
		String[] temp = new String[len];
		for (int i = 0; i < len; i++) {
			temp[i] = c[i + 1];
		}
		return temp;
	}

	private static String[] reverse(String[] c) {
		int len = c.length;
		String[] temp = new String[len];
		for (int i = 0; i < len; i++) {
			temp[i] = c[len - i - 1];
		}
		return temp;
	}

	private static void printAns(String[] c) throws IOException {
		if (c.length == 0) {
			bw.write("error\n");
		} else {
			bw.write(Arrays.toString(c).replace(" ", "") + "\n");
		}
	}
}
