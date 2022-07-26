import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 2665 미로만들기
 Date: 22-07-26
 Author: taeuk
 */
public class Main {
	static int n;
	static char[][] map;
	static int[][] visited;

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
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}

		bfs();

		System.out.println(visited[n - 1][n - 1]);
	}

	private static void bfs() {
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(0, 0));
		visited[0][0] = 0;

		while (!qu.isEmpty()) {
			Node cur = qu.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

				if (map[nx][ny] == '1') {
					if (visited[nx][ny] > visited[cur.x][cur.y]) {
						visited[nx][ny] = visited[cur.x][cur.y];
						qu.add(new Node(nx, ny));
					}
				} else {
					if (visited[nx][ny] > visited[cur.x][cur.y] + 1) {
						visited[nx][ny] = visited[cur.x][cur.y] + 1;
						qu.add(new Node(nx, ny));
					}
				}
			}
		}
	}
}
