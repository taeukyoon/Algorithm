import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 13023 ABCDE
 Date: 22-06-30
 Author: taeuk
 */
public class Main {
	static int n, m;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			dfs(i, 0);
		}
		System.out.println(0);
	}

	private static void dfs(int idx, int cnt) {
		if (cnt == 4) {
			System.out.println(1);
			System.exit(0);
		}

		visited[idx] = true;
		for (int i = 0; i < list[idx].size(); i++) {
			Integer tmp = list[idx].get(i);
			if (!visited[tmp]) {
				visited[tmp] = true;
				dfs(tmp, cnt + 1);
				visited[tmp] = false;
			}
		}
	}
}
