import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 13565 침투
 Date: 22-07-12
 Author: taeuk
 */
public class Main {
	static int m, n;
	static int[][] map;
	static boolean flag = false;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken()); // 행
		n = Integer.parseInt(st.nextToken()); //
		map = new int[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			if (map[0][i] == 0) {
				dfs(0, i);
			}
		}
		System.out.println((flag) ? "YES" : "NO");
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;

		if (r == m - 1) {
			flag = true;
			return;
		}

		for (int k = 0; k < 4; k++) {
			int nx = r + dx[k];
			int ny = c + dy[k];

			if (nx < 0 || ny < 0 || nx >= m || ny >= n)
				continue;
			if (map[nx][ny] == 1)
				continue;
			if (map[nx][ny] == 0 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}
