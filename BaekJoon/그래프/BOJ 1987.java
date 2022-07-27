import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1987 알파벳
 Date: 22-07-27
 Author: taeuk
 */
public class Main {
	static int r, c, max;
	static int[][] map;
	static boolean[] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[26];

        for (int i = 0; i < r; i++) {
        	String line = br.readLine();
        	for (int j = 0; j < c; j++) {
        		map[i][j] = line.charAt(j) - 'A';
			}
		}

        dfs(0, 0, 0);
		System.out.println(max);
    }

	private static void dfs(int x, int y, int cnt) {
		if (visited[map[x][y]]) {
			max = Math.max(max, cnt);
			return;
		}

		visited[map[x][y]] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
			dfs(nx, ny, cnt + 1);
		}
		visited[map[x][y]] = false;
	}
}
