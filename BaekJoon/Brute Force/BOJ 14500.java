import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 14500 테트로미노
 Date: 22-08-03
 Author: taeuk
 */
public class Main {
	static int n, m, max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, map[i][j], 1);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}

	private static void dfs(int x, int y, int sum, int count) {
		if (count == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (isRange(nx, ny))
				continue;
			if (!visited[nx][ny]) {
				if (count == 2) {
					visited[nx][ny] = true;
					dfs(x, y, sum + map[nx][ny], count + 1);
					visited[nx][ny] = false;
				}
				visited[nx][ny] = true;
				dfs(nx, ny, sum + map[nx][ny], count + 1);
				visited[nx][ny] = false;
			}
		}
	}

	private static boolean isRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= n;
	}
}
