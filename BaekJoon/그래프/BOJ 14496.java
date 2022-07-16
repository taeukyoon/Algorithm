import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 BOJ 14496 그대, 그머가 되어
 Date: 22-07-16
 Author: tauek
 */
public class Main {
	static int a, b, n, m;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	static int ans = 1001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}

		dijkstra();
		System.out.println((ans == 1001) ? -1 : ans);
	}

	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.add(new int[] {a, 0});
		visited[a] = true;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (cur[0] == b) {
				if (cur[1] < ans) {
					ans = cur[1];
					return;
				}
			}

			for (int i : list[cur[0]]) {
				if (!visited[i]) {
					pq.add(new int[] {i, cur[1] + 1});
					visited[i] = true;
				}
			}
		}
	}
}
