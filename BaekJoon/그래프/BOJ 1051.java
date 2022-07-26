import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1051 숫자 정사각형
 Date: 22-07-26
 Author: taeuk
 */
public class Main {
	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int size = Math.min(n, m);
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int s = 0; s < size; s++) {

					if (i + s < n && j + s < m) {
						if (map[i][j] == map[i][j + s] && map[i][j] == map[i + s][j]
							&& map[i][j] == map[i + s][j + s]) {
							int area =  (s + 1) * (s + 1);
							max = Math.max(max, area);
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
