import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 4963 섬의 개수
 Date: 22-07-11
 Author: taeuk
 */
public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
	static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
	public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
        	st = new StringTokenizer(br.readLine(), " ");
        	w = Integer.parseInt(st.nextToken());
        	h = Integer.parseInt(st.nextToken());

        	if (w == 0 && h == 0) break;
        	map = new int[h][w];
        	visited = new boolean[h][w];

        	for (int i = 0; i < h; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for (int j = 0; j < w; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int res = 0;
        	for (int i = 0; i < h; i++) {
        		for (int j = 0; j < w; j++) {
        			if (map[i][j] == 1 && !visited[i][j]) {
        				dfs(i, j);
        				res++;
					}
				}
			}
			System.out.println(res);
		}
    }

	private static void dfs(int i, int j) {
		visited[i][j] = true;

		for (int k = 0; k < 8; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
}
