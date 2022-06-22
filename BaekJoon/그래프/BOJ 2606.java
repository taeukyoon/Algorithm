import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;
	static int[][] node;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		node = new int[n + 1][n + 1];


		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b] = 1;
			node[b][a] = 1;
		}

		bfs(1);
		System.out.println(cnt);
	}

	private static void bfs(int start) {
		Queue<Integer> qu = new LinkedList<>();
		visited = new boolean[n + 1];

		qu.add(start);
		visited[start] = true;
		cnt = 0;
		while (!qu.isEmpty()) {
			int cur = qu.poll();

			for (int i = 1; i < node.length; i++) {
				if (node[cur][i] == 1 && !visited[i]) {
					qu.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
	}
}
