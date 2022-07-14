import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyed {
	static int n, m;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		dist = new int[n][n];

		// 플루이드 거리 테이블 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) { // 자기자신은 거리가 0
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = 100_000_000;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			dist[a][b] = Math.min(dist[a][b], cost);
			dist[b][a] = Math.min(dist[b][a], cost); // 최소비용 저장
		}

		// 플루이드 알고리즘
		// 노드 1개부터 N개까지 거쳐가는 경우 고려한다.
		for (int k = 0; k < n; k++) {
			// 노드 i에서 j로 가는 경우
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dist[i][j] == 100_000_000) {
					System.out.println("INF");
				} else {
					System.out.print(dist[i][j] + "");
				}
			}
			System.out.println();
		}
	}
}
