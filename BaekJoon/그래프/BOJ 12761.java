import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 12761 돌다리
 Date: 22-07-14
 Author: taeuk
 */
public class Main {
	static int a, b, n, m;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];

		bfs();
	}

	private static void bfs() {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(n, 0));
		visited[n] = true;

		while (!qu.isEmpty()) {
			Point cur = qu.poll();

			if (cur.x == m) {
				System.out.println(cur.y);
				return;
			}

			for (int k = 0; k < 8; k++) {
				int nx = move(cur.x, k);

				if (isRange(nx))
					continue;
				if (!visited[nx]) {
					visited[nx] = true;
					qu.add(new Point(nx, cur.y + 1));
				}
			}
		}
	}

	private static boolean isRange(int nx) {
		return nx < 0 || nx > 100000;
	}

	private static int move(int x, int d) {
		if (d == 0)
			return x - 1;
		else if (d == 1)
			return x + 1;
		else if (d == 2)
			return x - a;
		else if (d == 3)
			return x + a;
		else if (d == 4)
			return x - b;
		else if (d == 5)
			return x + b;
		else if (d == 6)
			return x * a;
		else
			return x * b;
	}
}
