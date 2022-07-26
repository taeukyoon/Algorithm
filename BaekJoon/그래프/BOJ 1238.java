import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 BOJ 1238 파티
 Date: 22-07-25
 Author: taeuk
 */
public class Main {
	private static final int INF = 200_000_000;
	static int n, m, x;
	static boolean[] check;
	static int[] dist, backDist;
	static ArrayList<Node>[] list;
	static ArrayList<Node>[] backList;

	static class Node implements Comparable<Node> {
		int e, time;

		public Node(int e, int time) {
			this.e = e;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return time - o.time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		backList = new ArrayList[n + 1];
		dist = new int[n + 1];
		backDist = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
			backList[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			list[s].add(new Node(e, t));
			backList[e].add(new Node(s, t));
		}

		Arrays.fill(dist, INF);
		Arrays.fill(backDist, INF);
		dijkstra(list, dist, x);
		dijkstra(backList, backDist, x);

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dist[i] + backDist[i]);
		}
		System.out.println(max);
	}

	private static void dijkstra(ArrayList<Node>[] list, int[] dist, int s) {
		check = new boolean[n + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(s, 0));
		dist[s] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int curNode = cur.e;

			if (check[curNode]) continue;
			check[curNode] = true;

			for (Node node : list[curNode]) {
				if (dist[node.e] > dist[curNode] + node.time) {
					dist[node.e] = dist[curNode] + node.time;
					pq.add(new Node(node.e, dist[node.e]));
				}
			}
		}
	}
}
