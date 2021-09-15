package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ICPC {
	static int T;
	static int M, N, x, y;
	static int standard;
	static int dx, dy;
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
            standard = M;
            dy = x % N != 0 ? x % N : N;
            int count = 0;
            while(true){
                set.add(dy);
                if(dy == y){
                    sb.append(count + x +"\n");
                    break;
                }
                dy = (dy + M) % N;
                dy = dy == 0 ? N : dy;
                count += M;
                if(set.contains(dy)){
                    sb.append("-1\n");
                    break;
                }
            }
            set.clear();
		}
        System.out.println(sb);

	}
}
