import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1025 제곱수 찾기
 Date: 22-08-02
 Author: taeuk
 */
public class Main {
	static int n, m, ans = Integer.MIN_VALUE;
	static String[] arr;
	static int[][] map;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		arr = new String[n + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = arr[i].charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int x = -n; x < n; x++) { // 이부분 풀이 (행의 등차값)
					for (int y = -m; y < m; y++) {
						if (x == 0 && y == 0) continue;
						int a = i, b = j;
						int now = 0;

						while (a >= 0 && b >= 0 && a < n && b < m) {
							now *= 10; // 선택된 값 십의자리 백의자리 ..
							now += map[a][b];
							if (isSquare(now)) ans = Math.max(ans, now);
							a += x; // 등차수열
							b += y;
						}
						if (isSquare(now)) ans = Math.max(ans, now);
					}
				}
			}
		}
		System.out.println((ans == Integer.MIN_VALUE) ? -1 : ans);
	}

	private static boolean isSquare(int now) {
		int sqrt = (int)Math.sqrt(now);
		if (sqrt * sqrt == now) return true;
		return false;
	}
}
