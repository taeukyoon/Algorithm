import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 16174 점프왕 쩰리
 Date: 22-07-19
 Author: taeuk
 */
public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println("Hing");
	}

	private static void dfs(int x, int y) {
		int jump = map[x][y];
		visited[x][y] = true;

		if (map[x][y] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}

		for (int k = 0; k < 2; k++) {
			int nx = x + dx[k] * jump;
			int ny = y + dy[k] * jump;

			if (isRange(nx, ny))
				continue;
			if (visited[nx][ny])
				continue;
			dfs(nx, ny);
		}
	}

	private static boolean isRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= n;
	}

}
