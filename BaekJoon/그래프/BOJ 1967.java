import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 1967 트리의 지름
 Date: 22-07-04
 Author: taeuk
 */
public class Main {
	static int n, max, temp, ans;
	static boolean[] visited;
	static ArrayList<Node>[] list;

	static class Node {
		int c, amount;

		public Node(int c, int amount) {
			this.c = c;
			this.amount = amount;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			list[p].add(new Node(c, val));
			list[c].add(new Node(p, val));
		}

		visited[1] = true;
		temp = 0; max = 0;
		dfs(1, 0);

		visited = new boolean[n + 1];
		visited[temp] = true;
		dfs(temp, 0);

		System.out.println(max);
	}

	private static void dfs(int idx, int value) {
		if (max < value) {
			max = value;
			temp = idx;
		}

		for (Node n : list[idx]) {
			if (!visited[n.c]) {
				visited[n.c] = true;
				dfs(n.c, value + n.amount);
			}
		}
	}
}
