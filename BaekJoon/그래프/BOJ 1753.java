import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 BOJ 1753 최단경로
 Date: 22-07-25
 Author: taeuk
 */
public class Main {
	private static final int INF = 200_000_000;
	static int v, e;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<Node>[] list;

	static class Node implements Comparable<Node> {
		int e, distance;

		public Node(int e, int distance) {
			this.e = e;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		dist = new int[v + 1];
		visited = new boolean[v + 1];
		list = new ArrayList[v + 1];

		for (int i = 0; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new Node(v, w));
		}

		Arrays.fill(dist, INF);
		dijkstra(k);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (dist[i] == INF)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int s) {
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

				if (dist[node.e] > dist[curNode] + node.distance) {
					dist[node.e] = dist[curNode] + node.distance;
					pq.add(new Node(node.e, dist[node.e]));
				}
			}
		}
	}
}
