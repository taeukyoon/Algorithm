import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 BOJ 1504 특정한 최다경로
 Date: 22-07-25
 Author: taeuk
 */
public class Main {
	private static final int INF = 200_000_000;
	static int n, e, v1, v2;
	static boolean[] visited;
	static int[] dist;
	static ArrayList<Node>[] list;

	static class Node implements Comparable<Node> {
		int e, dist;

		public Node(int e, int dist) {
			this.e = e;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		dist = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine(), " ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		int res = process(v1, v2);
		System.out.println(res);
	}

	private static int process(int val1, int val2) {
		int res1 = 0, res2 = 0;

		res1 += dijkstra(1, val1);
		res1 += dijkstra(val1, val2);
		res1 += dijkstra(val2, n);

		res2 += dijkstra(1, val2);
		res2 += dijkstra(val2, val1);
		res2 += dijkstra(val1, n);

		if (res1 >= INF && res2 >= INF)
			return -1;
		return Math.min(res1, res2);
	}

	private static int dijkstra(int s, int end) {
		Arrays.fill(dist, INF);
		visited = new boolean[n + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int curNode = cur.e;

			if (visited[curNode])
				continue;
			visited[curNode] = true;

			for (Node node : list[curNode]) {
				if (!visited[node.e] && dist[node.e] > dist[curNode] + node.dist) {
					dist[node.e] = dist[curNode] + node.dist;
					pq.add(new Node(node.e, dist[node.e]));
				}
			}
		}
		return dist[end];
	}
}
