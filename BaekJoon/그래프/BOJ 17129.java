import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 17129
 Date: 22-07-21
 Author: taeuk
 */
public class Main {
	static int n, m, min = 0;
	static boolean flag = false;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Node> qu;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Node {
		int x, y, time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		qu = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';

				if (map[i][j] == 2)
					qu.add(new Node(i, j, 0));
			}
		}

		bfs();
		if (flag) {
			System.out.println("TAK");
			System.out.println(min);
		} else {
			System.out.println("NIE");
		}
	}

	private static void bfs() {
		while (!qu.isEmpty()) {
			Node cur = qu.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 1 || visited[nx][ny])
					continue;
				if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
					min = cur.time + 1;
					flag = true;
					return;
				}

				visited[nx][ny] = true;
				qu.add(new Node(nx, ny, cur.time + 1));
			}
		}
	}
}
