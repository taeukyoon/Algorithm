import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1743 음식물 피하기
 Date: 22-07-15
 Author: taeuk
 */
public class Main {
	static int n, m, k, max;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			map[r][c] = true;
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] && !visited[i][j]) {
					max = 0;
					dfs(i, j);
					res = Math.max(res, max);
				}
			}
		}
		System.out.println(res);
	}

	private static void dfs(int r, int c) {
		max++;
		visited[r][c] = true;

		for (int k = 0; k < 4; k++) {
			int nx = r + dx[k];
			int ny = c + dy[k];

			if (isRange(nx, ny))
				continue;
			if (map[nx][ny] && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

	private static boolean isRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= m;
	}

}
