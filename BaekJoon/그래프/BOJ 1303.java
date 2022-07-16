import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1303 전쟁 - 전투
 Date: 22-07-16
 Author: taeuk
 */
public class Main {
	static int n, m, white, blue, count;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'W' && !visited[i][j]) {
					count = 0;
					white += dfs(i, j, map[i][j]);
				} else if (map[i][j] == 'B' && !visited[i][j]) {
					count = 0;
					blue += dfs(i, j, map[i][j]);
				}
			}
		}
		System.out.println(white + " " + blue);
	}

	private static int dfs(int x, int y, char color) {
		count++;
		visited[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || ny < 0 || nx >= m || ny >= n)
				continue;
			if (map[nx][ny] == color && !visited[nx][ny]) {
				dfs(nx, ny, color);
			}
		}
		return count * count;
	}
}
