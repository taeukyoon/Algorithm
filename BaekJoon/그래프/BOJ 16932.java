import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 BOJ 16932 모양 만들기
 Date: 22-07-03
 Author: taeuk
 */
public class Main {
	static int n, m, res = 1, val = 1;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					map[i][j] = val;
					list.add(dfs(i, j, val++));
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					sum = calSum(i, j);
					res = Math.max(res, sum);
				}
			}
		}

		System.out.println(res);
	}

	private static int calSum(int x, int y) {
		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (isaBoolean(nx, ny))
				continue;
			if (map[nx][ny] > 0) {
				set.add(map[nx][ny] - 1); // -1은 리스트 값과 맞추기위해서
			}
		}

		for (Integer i : set) {
			sum += list.get(i);
		}
		return sum + 1;
	}

	private static int dfs(int x, int y, int val) {
		int count = 1;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (isaBoolean(nx, ny))
				continue;
			if (map[nx][ny] == 1 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				map[nx][ny] = val;
				count += dfs(nx, ny, val);
			}
		}
		return count;
	}

	private static boolean isaBoolean(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= m;
	}
}
