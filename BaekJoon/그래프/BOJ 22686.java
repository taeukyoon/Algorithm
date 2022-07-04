import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 22868 산책 (small)
 Date: 22-07-04
 Author: taeuk
 */
public class Main {
	static int n, m, s, e, result;
	static int[] temp;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	static class Node {
		public Node(int s, int count) {
			this.s = s;
			this.count = count;
		}

		int s, count;
	}
    public static void main(String[] args)throws IOException {
		input();
		process();
		System.out.println(result);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		temp = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		st = new StringTokenizer(br.readLine(), " ");
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
	}

	private static void process() {
    	for (int i = 1; i <= n; i++) Collections.sort(list[i]);
    	bfs(s, e); // s ---> e

		for (int i = 1; i <= n; i++) visited[i] = false;

		int last = temp[e];
		while (last > 0) {
			visited[last] = true;
			last = temp[last];
		}

		bfs(e, s);
	}

	// s --> e 에서 방문한 경로를 기억해야한다.
	private static void bfs(int s, int e) {
		Queue<Node> qu = new LinkedList<>();
		visited[s] = true;
		qu.add(new Node(s, 0));

		while (!qu.isEmpty()) {
			Node cur = qu.poll();

			for (int n : list[cur.s]) {
				if (!visited[n]) {
					visited[n] = true;
					temp[n] = cur.s; // 2 -> 1
					qu.add(new Node(n, cur.count + 1));
				}

				if (n == e) {
					result += cur.count + 1;
					return;
				}
			}
		}
	}
}
