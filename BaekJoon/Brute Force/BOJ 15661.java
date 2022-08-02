import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 15661 링크와 스타트
 Date: 22-08-02
 Author: taeuk
 */
public class Main {
	static int n, min = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0, 0, 0, 0);
		System.out.println(min / 2);
	}

	private static void solve(int idx, int start, int link, int startSum, int linkSum) {
		if (idx == n) {
			min = Math.min(min, Math.abs(startSum - linkSum));
			return;
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (i == idx)
				continue;

			sum += map[i][idx];
			sum += map[idx][i];
		}
		solve(idx + 1, start + 1, link, startSum + sum, linkSum);
		solve(idx + 1, start, link + 1, startSum, linkSum + sum);
	}
}
