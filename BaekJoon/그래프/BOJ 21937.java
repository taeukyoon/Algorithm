import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 21937 작업
 Date: 22-07-19
 Author: tauek
 */
public class Main {
	static int n, m, x, count;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[b].add(a);
		}

		x = Integer.parseInt(br.readLine());

		dfs(x);
		System.out.println(count);
	}

	private static void dfs(int x) {
		visited[x] = true;
		for (Integer i : list[x]) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}
	}
}
