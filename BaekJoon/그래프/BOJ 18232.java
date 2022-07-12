import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 18232 텔레포트 정거장
 Date: 22-07-12
 Author: taeuk
 */
public class Main {
	static int n, m, s, e, time;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()); // 정거장
		m = Integer.parseInt(st.nextToken()); // 텔레포트 정보
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine(), " ");
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}
		bfs(s);
	}

	private static void bfs(int start) {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(start, 0));
		visited[start] = true;

		while (!qu.isEmpty()) {
			Point cur = qu.poll();
			int cnt = cur.y;

			if (cur.x == e) {
				System.out.println(cnt);
				return;
			}

			if (cur.x - 1 > 0 && !visited[cur.x - 1]) {
				visited[cur.x - 1] = true;
				qu.add(new Point(cur.x - 1, cnt + 1));
			}
			if (cur.x + 1 <= n && !visited[cur.x + 1]) {
				visited[cur.x + 1] = true;
				qu.add(new Point(cur.x + 1, cnt + 1));
			}

			for (int i = 0; i < list[cur.x].size(); i++) {
				int tmp = list[cur.x].get(i);

				if (!visited[tmp]) {
					qu.add(new Point(tmp, cnt + 1));
				}
			}
		}
	}
}
