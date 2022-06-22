import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 1325 효율적인 해킹
 Date: 22-06-22
 Author: taeuk
 */
public class Main {
	static int n, m;
	static ArrayList<Integer> list[];
	static boolean[] visited;
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}

		res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			bfs(i);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, res[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (max == res[i]) {
				sb.append(i + " ");
			}
		}

		System.out.println(sb.toString());
	}

	private static void bfs(int start) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(start);
		visited[start] = true;

		while (!qu.isEmpty()) {
			Integer node = qu.remove();
			for (int n : list[node]) {
				if (!visited[n]) {
					visited[n] = true;
					res[n]++;
					qu.add(n);
				}
			}
		}
	}
}
