import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 2589 보물섬
 Date: 22-07-20
 Author: taeuk
 */
public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L' && isStartPoint(i, j)) {
					visited = new boolean[n][m];
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		System.out.println(max);
	}

	private static boolean isStartPoint(int x, int y) {
		int count = 0, wCount = 0, hCount = 0;

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (isRange(nx, ny))
				continue;
			if (map[nx][ny] == 'L') {
				count++;
				if (k == 0 || k == 1)
					hCount++;
				else
					wCount++;
			}
		}
		return count == 1 || (count == 2 && wCount == 1 && hCount == 1);
	}

	private static int bfs(int x, int y) {
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(x, y, 0));
		visited[x][y] = true;
		int distance = 0;

		while (!qu.isEmpty()) {
			Node cur = qu.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (isRange(nx, ny))
					continue;
				if (!visited[nx][ny] && map[nx][ny] == 'L') {
					qu.add(new Node(nx, ny, cur.cnt + 1));
					visited[nx][ny] = true;
					distance = Math.max(distance, cur.cnt + 1);
				}
			}
		}
		return distance;
	}

	private static boolean isRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= m;
	}
}
