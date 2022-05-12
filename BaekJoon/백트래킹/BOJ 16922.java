import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 16922 로마 숫자 만들기
 Date: 22-05-12
 Author: taeuk
 */
public class Main {
	static int n, cnt;
	static int[] list = {1, 5, 10, 50};
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		visited = new boolean[10001];
		backtracking(0, 0, 0);

		System.out.println(cnt);
	}

	private static void backtracking(int count, int sum, int index) {
		if (count == n) {
			if (!visited[sum]) {
				visited[sum] = true;
				cnt++;
			}
			return;
		}

		for (int i = index; i < list.length; i++) {
			backtracking(count + 1, sum + list[i], i);
		}
	}
}
