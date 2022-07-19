import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 14716 현수막
 Date: 22-07-18
 Author: taeuk
 */
public class Main {
	static int m, n;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for (int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

        int count = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (map[i][j] == 1 && !visited[i][j]) {
        			count++;
        			bfs(i, j);
				}
			}
		}
		System.out.println(count);
    }

	private static void bfs(int x, int y) {
		Queue<Point> qu = new LinkedList<>();
		visited[x][y] = true;
		qu.add(new Point(x,  y));

		while (!qu.isEmpty()) {
			Point cur = qu.poll();

			for (int k = 0; k < 8; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
				if (map[nx][ny] == 0 || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				qu.add(new Point(nx,ny));
			}
		}
	}
}
