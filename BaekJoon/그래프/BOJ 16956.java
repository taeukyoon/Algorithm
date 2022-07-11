import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 16956 늑대와 양
 Date: 22-07-11
 Author: taeuk
 */
public class Main {
	static int r, c;
	static char[][] map;
	static Queue<Node> qu;
	static boolean flag = true;
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

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		qu = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'W') {
					qu.add(new Node(i, j));
				}
			}
		}
		bfs();

		if (flag) {
			System.out.println(1);

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		System.out.println(0);
	}

	private static void bfs() {

		while (!qu.isEmpty()) {
			Node now = qu.poll();

			for (int k = 0; k < 4; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];

				if (isRange(nx, ny))
					continue;

				if (map[nx][ny] == 'S') {
					flag = false;
					return;
				}
				if (map[nx][ny] == '.') {
					map[nx][ny] = 'D';
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= r || ny >= c;
	}
}
