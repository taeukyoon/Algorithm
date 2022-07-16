import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 15558 점프 게임
 Date: 22-07-16
 Author: taeuk
 */
public class Main {
	static int n, k;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[2][n];
		visited = new boolean[2][n];

		for (int i = 0; i < 2; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs();
	}

	private static void bfs() {
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {0, 0, 0});
		visited[0][0] = true;
		int[] dx = {-1, 1, k};

		while (!qu.isEmpty()) {
			int[] cur = qu.poll();

			for (int d = 0; d < 3; d++) {
				int line = cur[0];
				int nc = cur[1] + dx[d];
				int time = cur[2];

				if (d == 2) {
					if (cur[0] == 1) {
						line = 0;
					} else {
						line = 1;
					}
				}

				if (nc >= n) {
					System.out.println(1);
					System.exit(0);
				}
				if (nc <= time)
					continue;
				if (visited[line][nc])
					continue;
				if (map[line][nc] == 0)
					continue;
				visited[line][nc] = true;
				qu.add(new int[] {line, nc, time + 1});
			}
		}
		System.out.println(0);
	}
}
