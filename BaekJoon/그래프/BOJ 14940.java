import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 14940 쉬운 최단거리
 Date: 22-06-28
 Author: taeuk
 */
public class Main {
	static int n, m;
	static int[][] map, copyMap;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Queue<Node> qu;
	static StringBuilder sb = new StringBuilder();

	static class Node {

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		int x, y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n][m];
		copyMap = new int[n][m];
		map = new int[n][m];
		qu = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					qu.add(new Node(i, j));
					visited[i][j] = true;
				}
			}
		}

		bfs();
		print();
		System.out.println(sb);
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					sb.append(-1).append(" ");
					continue;
				}
				sb.append(copyMap[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}

	private static void bfs() {
		while (!qu.isEmpty()) {
			Node cur = qu.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if (map[nx][ny] == 0 || visited[nx][ny]) continue;

				visited[nx][ny] = true;
				qu.add(new Node(nx, ny));
				copyMap[nx][ny] = copyMap[cur.x][cur.y] + 1;
			}
		}

	}
}
