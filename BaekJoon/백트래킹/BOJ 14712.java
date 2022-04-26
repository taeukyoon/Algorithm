import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 14712
 author: taeuk
 Date: 22-04-26
 */
public class Main {
	static int n, m, res;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];

		dfs(0);

		System.out.println(res);
	}

	// 넴모가 생기지 않도록 전체칸을 확인한다.
	// cnt는 확인한 확인한 칸의 개수이다.

	public static void dfs(int cnt) {
		if (cnt == n * m) {
			res++;
			return;
		}

		// 현재 칸의 좌표
		int y = cnt / m + 1;
		int x = cnt % m + 1;

		// 해당칸을 기준으로 상, 좌, 상좌에 모두 넴모가 채워져 있으면 넘긴다.
		if (map[y - 1][x] == 1 && map[y][x - 1] == 1 && map[y - 1][x - 1] == 1) {
			dfs(cnt + 1);
		} else { // 3곳중 하나라도 네모가 없을경우
			dfs(cnt + 1); // 현재 넴모 x 다음꺼
			map[y][x] = 1;
			dfs(cnt + 1); // 현재 넴모 o 다음꺼
			map[y][x] = 0;
		}
	}
}
