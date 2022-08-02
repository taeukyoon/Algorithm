import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 2961 도영이 만든 맛있는 음식
 Date: 22-08-02
 Author: taeuk
 */
public class Main {
	static int n, min = Integer.MAX_VALUE;
	static int[] s, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		s = new int[n];
		b = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 1, 0);
		System.out.println(min);
	}

	private static void dfs(int input, int cnt, int sour, int bitter) {
		if (cnt == n) {
			if (input != 0) {
				min = Math.min(min, Math.abs(sour - bitter));
			}
			return;
		}

		dfs(input + 1, cnt + 1, sour * s[cnt], bitter + b[cnt]);
		dfs(input, cnt + 1, sour, bitter);
	}
}
