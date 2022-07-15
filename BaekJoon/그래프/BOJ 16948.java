import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 16948 데스 나이트
 Date: 22-07-15
 Author: taeuk
 */
public class Main {
	static int n, r2, c2;
	static boolean[][] visited;
	static int[] dx = {-2, -2, 0, 0, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -1, 1};

	static class Knight {
		int x, y, count;

		public Knight(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];

		st = new StringTokenizer(br.readLine(), " ");
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		bfs(r1, c1);
	}

	private static void bfs(int x, int y) {
		Queue<Knight> qu = new LinkedList<>();
		qu.add(new Knight(x, y, 0));
		visited[x][y] = true;

		while (!qu.isEmpty()) {
			Knight cur = qu.poll();

			for (int k = 0; k < 6; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (isRange(nx, ny))
					continue;

				if (nx == r2 && ny == c2) {
					System.out.println(cur.count + 1);
					System.exit(0);
				}

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					qu.add(new Knight(nx, ny, cur.count + 1));
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean isRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= n;
	}

}
