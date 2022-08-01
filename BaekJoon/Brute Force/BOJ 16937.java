import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 16937 두 스티커
 Date: 22-07-31
 Author: taeuk
 */
public class Main {
	static int h, w, n, max;
	static boolean[][] map;
	static boolean[] visited;
	static ArrayList<Node> list;

	static class Node {
		int h, w, id;

		public Node(int h, int w, int id) {
			this.h = h;
			this.w = w;
			this.id = id;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());

		map = new boolean[h][w];
		visited = new boolean[n];
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.add(new Node(r, c, i));
			list.add(new Node(c, r, i));
		}

		prcoess(0, 0);
		System.out.println(max);
	}

	private static void prcoess(int cnt, int size) {
		if (cnt == 2) {
			max = Math.max(max, size);
			return;
		}

		for (Node node : list) {

			if (!visited[node.id]) {
				Node start = findStart(node);

				if (start == null)
					continue;

				attach(start, node, true);
				visited[node.id] = true;
				prcoess(cnt + 1, size + node.h * node.w);
				visited[node.id] = false;
				attach(start, node, false);
			}
		}
	}

	private static void attach(Node start, Node node, boolean type) {
		for (int r = start.h; r < start.h + node.h; ++r) {
			for (int c = start.w; c < start.w + node.w; ++c) {
				map[r][c] = type;
			}
		}
	}

	private static Node findStart(Node node) {
		for (int r = 0; r <= h - node.h; ++r) {
			for (int c = 0; c <= w - node.w; ++c) {
				if (map[r][c])
					continue;

				boolean attach = true;
				for (int i = r; i < r + node.h; ++i) {
					for (int j = c; j < c + node.w; ++j) {
						if (map[i][j]) {
							attach = false;
							break;
						}
					}

					if (!attach)
						break;
				}
				if (attach)
					return new Node(r, c, -1);
			}
		}
		return null;
	}
}
