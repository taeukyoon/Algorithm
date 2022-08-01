import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 16439 치킨치킨치킨
 Date: 23-08-01
 Author: taeuk
 */
public class Main {
	static int n, m, res;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, new int[3]);
		System.out.println(res);
	}

	private static void comb(int depth, int[] val) {
		if (depth == 3) {
			int sum = 0;

			for (int i = 0; i < n; i++) {
				int tmp = 0;
				for (int j = 0; j < 3; j++) {
					tmp = Math.max(tmp, arr[i][val[j]]);
				}
				sum += tmp;
			}

			res = Math.max(res, sum);
			return;
		}

		for (int i = 0; i < m; i++) {
			val[depth] = i;
			comb(depth + 1, val);
		}
	}
}
