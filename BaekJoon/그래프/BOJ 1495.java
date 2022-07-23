import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1495 기타리스트
 Date: 22-07-23
 Author: taeuk
 */
public class Main {
	static int n, s, m;
	static int[] v;
	static int[][] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = new int[n + 1];
		dp = new int[n + 1][m + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}

		nextVolume(1, s);

		boolean flag = true;
		for (int i = m; i >= 0; i--) {
			if (dp[n][i] == 1) {
				System.out.println(i);
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println(-1);
    }

	private static void nextVolume(int idx, int vol) {
		if (idx == n + 1) return;

		if (vol + v[idx] <= m) {
			if (dp[idx][vol + v[idx]] == 0) {
				dp[idx][vol + v[idx]] = 1;
				nextVolume(idx + 1, vol + v[idx]);
			}
		}

		if (vol - v[idx] >= 0) {
			if (dp[idx][vol - v[idx]] == 0) {
				dp[idx][vol - v[idx]] = 1;
				nextVolume(idx + 1, vol - v[idx]);
			}
		}
	}
}
