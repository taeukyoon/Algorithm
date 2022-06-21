import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 1260 dfs, bfs
 */
public class Main {
	static int n, m, v;
	static int[][] node;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		node = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b] = 1;
			node[b][a] = 1;
		}

		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();
		visited = new boolean[n + 1];
		bfs(v);
	}

	private static void bfs(int start) {
		Queue<Integer> qu = new LinkedList<>();

		qu.add(start);
		visited[start] = true;
		System.out.print(start + " ");

		while (!qu.isEmpty()) {
			int cur = qu.poll();
			for (int i = 1; i < node.length; i++) {
				if (node[cur][i] == 1 && !visited[i]) {
					qu.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}

	private static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");

		for (int i = 1; i <= n; i++) {
			if (node[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
