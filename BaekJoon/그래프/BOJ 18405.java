import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 18405 경쟁적 전염
 Date: 22-07-15
 Author: taeuk
 */
public class Main {
	static int n, k, s, x, y;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		loop:
		for (int i = 0; i < s; i++) {
			for (int j = 1; j <= k; j++) {
				bfs(j);

				if (map[x][y] != 0)
					break loop;
			}
		}

		System.out.println((map[x][y] != 0) ? map[x][y] : 0);
	}

	private static void bfs(int virusNum) {
		Queue<Node> qu = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == virusNum) {
					qu.add(new Node(i, j));
				}
			}
		}

		while (!qu.isEmpty()) {
			Node cur = qu.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (isRange(nx, ny))
					continue;
				if (map[nx][ny] != 0)
					continue;

				map[nx][ny] = virusNum;
			}
		}
	}

	private static boolean isRange(int nx, int ny) {
		return nx < 1 || ny < 1 || nx > n || ny > n;
	}
}
