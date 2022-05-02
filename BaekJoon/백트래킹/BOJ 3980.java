import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 3980
 Author: taeuk
 Date: 22-05-02
 */
public class Main {
	static int t, max;
	static int[][] position;
	static boolean[] visited;
	static final int TOTAL = 11;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		position = new int[TOTAL][TOTAL];

		for (int i = 0; i < t; i++) {
			visited = new boolean[TOTAL];
			max = Integer.MIN_VALUE;
			for (int a = 0; a < TOTAL; a++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int b = 0; b < TOTAL; b++) {
					position[a][b] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			System.out.println(max);
		}
	}

	public static void dfs(int sum, int cnt) {
		if (cnt == TOTAL) {
			max = Math.max(max, sum);
			return;
		}

		// 한 행당 하나 선택
		for (int i = 0; i < TOTAL; i++) {
			if (!visited[i] && position[cnt][i] != 0) {
				visited[i] = true;
				dfs(sum + position[cnt][i], cnt + 1);
				visited[i] = false;
			}
		}
	}
}
