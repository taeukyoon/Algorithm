import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 3184 양
 Date: 22-07-11
 Author: taeuk
 */
public class Main {
	static int r, c, O, V;
	static char[][] map;
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

		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '#')
					continue;
				dfs(i, j);
			}
		}
		System.out.println(O + " " + V);
	}

	private static void dfs(int x, int y) {
		int countO = 0;
		int countV = 0;

		Queue<Node> qu = new LinkedList<>();
		if (map[x][y] == 'o')
			countO++;
		if (map[x][y] == 'v')
			countV++;

		map[x][y] = '#';
		qu.add(new Node(x, y));

		while (!qu.isEmpty()) {
			Node cur = qu.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (isRange(nx, ny))
					continue;
				if (map[nx][ny] == '#')
					continue;
				if (map[nx][ny] == 'o')
					countO++;
				if (map[nx][ny] == 'v')
					countV++;

				map[nx][ny] = '#';
				qu.add(new Node(nx, ny));
			}
		}
		if (countO > countV)
			O += countO;
		else
			V += countV;
	}

	private static boolean isRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= r || ny >= c;
	}
}
