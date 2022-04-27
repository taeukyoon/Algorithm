import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 18430 무기 공학
 Author: taeuk
 Date: 22-04-26
 */
public class Main {
	static int n, m;
	static int res = Integer.MIN_VALUE;
	static int[][] wood;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		wood = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				wood[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(res);
	}

	// 3개 이상 'ㄱ'자 모양 부메랑이여야 한다.
	public static void dfs(int sum, int idx) {
		if (idx == n * m) {
			res = Math.max(res, sum);
			return;
		}

		// 현재 위치
		int r = idx / m;
		int c = idx % m;

		if (!visited[r][c]) {
			if (r + 1 < n && c - 1 >= 0 && !visited[r + 1][c] && !visited[r][c - 1]) {
				visited[r][c] = true;
				visited[r + 1][c] = true;
				visited[r][c - 1] = true;
				int now = sum + rightUp(r, c);
				dfs(now, idx + 1);
				visited[r][c] = false;
				visited[r + 1][c] = false;
				visited[r][c - 1] = false;
			}

			if (r - 1 >= 0 && c - 1 >= 0 && !visited[r - 1][c] && !visited[r][c - 1]) {
				visited[r][c] = true;
				visited[r - 1][c] = true;
				visited[r][c - 1] = true;
				int now = sum + rightDown(r, c);
				dfs(now, idx + 1);
				visited[r][c] = false;
				visited[r - 1][c] = false;
				visited[r][c - 1] = false;
			}

			if (r - 1 >= 0 && c + 1 < m && !visited[r - 1][c] && !visited[r][c + 1]) {
				visited[r][c] = true;
				visited[r - 1][c] = true;
				visited[r][c + 1] = true;
				int now = sum + leftDown(r, c);
				dfs(now, idx + 1);
				visited[r][c] = false;
				visited[r - 1][c] = false;
				visited[r][c + 1] = false;
			}

			if (r + 1 < n && c + 1 < m && !visited[r + 1][c] && !visited[r][c + 1]) {
				visited[r][c] = true;
				visited[r + 1][c] = true;
				visited[r][c + 1] = true;
				int now = sum + leftUp(r, c);
				dfs(now, idx + 1);
				visited[r][c] = false;
				visited[r + 1][c] = false;
				visited[r][c + 1] = false;
			}
		}
		dfs(sum, idx + 1);
	}

	// 4가지 모양의 'ㄱ'의 값 구하기
	// 중심은 2배의 강도
	private static int rightUp(int r, int c) {
		return wood[r][c] * 2 + wood[r + 1][c] + wood[r][c - 1];
	}

	private static int rightDown(int r, int c) {
		return wood[r][c] * 2 + wood[r - 1][c] + wood[r][c - 1];
	}

	private static int leftDown(int r, int c) {
		return wood[r][c] * 2 + wood[r - 1][c] + wood[r][c + 1];
	}

	private static int leftUp(int r, int c) {
		return wood[r][c] * 2 + wood[r + 1][c] + wood[r][c + 1];
	}
}
