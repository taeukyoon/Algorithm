import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 14620 꽃길
 Date: 22-08-01
 Author: taeuk
 */
public class Main {
	static int n, min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

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
		System.out.println(min);
	}

	private static void dfs(int cnt, int total) {
		if (cnt == 3) {
			min = Math.min(min, total);
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check(i, j)) {
					int price = sum(i, j);
					setVisited(i, j, true);
					dfs(cnt + 1, total + price);
					setVisited(i, j, false);
				}
			}
		}
	}

	private static void setVisited(int x, int y, boolean type) {
		visited[x][y] = type;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			visited[nx][ny] = type;
		}
	}

	private static int sum(int x, int y) {
		int val = map[x][y];
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			val += map[nx][ny];
		}
		return val;
	}

	private static boolean check(int x, int y) {
		if (visited[x][y])
			return false;

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (isRange(nx, ny))
				return false;
			if (visited[nx][ny])
				return false;
		}
		return true;
	}

	private static boolean isRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= n;
	}
}
