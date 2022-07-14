import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 21983 영상처리
 Date: 22-07-14
 Author: tauek
 */
public class Main {
	static int n, m, t, count;
	static double[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		input();
		average();
		answer();
	}

	private static void answer() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static void average() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] >= t) {
					map[i][j] = 255;
					continue;
				}
				map[i][j] = 0;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new double[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				double rgb = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(
					st.nextToken());
				rgb /= 3; // 평균
				map[i][j] = rgb;
			}
		}

		t = Integer.parseInt(br.readLine());
	}

	private static void bfs(int x, int y) {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(x, y));
		visited[x][y] = true;

		while (!qu.isEmpty()) {
			Point cur = qu.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (map[nx][ny] > 0 && !visited[nx][ny]) {
					qu.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
}
