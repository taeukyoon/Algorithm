import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 18429 근손실
 Date: 22-05-12
 Author: taeuk
 */
public class Main {
	static int n, k, count;
	static int[] amount;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		amount = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			amount[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 500);
		System.out.println(count);
	}

	private static void dfs(int index, int weight) {
		if (index == n) {
			count++;
			return;
		}

		for (int i = 0; i < n; i++) {
			recursion(index, weight, i);
		}
	}

	private static void recursion(int index, int weight, int i) {
		if (!visited[i] && (weight + amount[i] - k) >= 500) {
			visited[i] = true;
			dfs(index + 1, weight + amount[i] - k);
			visited[i] = false;
		}
	}
}
