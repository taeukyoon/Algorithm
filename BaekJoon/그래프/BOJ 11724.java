import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 11724 연결 요소의 개수
 Date: 22-07-11
 Author: taeuk
 */
public class Main {
	static int n, m, res;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[1001][1001];
		visited = new boolean[1001];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			arr[u][v] = arr[v][u] = 1;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				res++;
			}
		}

		System.out.println(res);
	}

	private static void dfs(int i) {
		visited[i] = true;

		for (int k = 1; k <= n; k++) {
			if (arr[i][k] == 1 && !visited[k]) {
				dfs(k);
			}
		}
	}
}
