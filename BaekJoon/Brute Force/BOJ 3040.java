import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 3040 백설 공주와 일곱 난쟁이
 Date: 22-08-03
 Author: taeuk
 */
public class Main {
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[9];
		visited = new boolean[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		solve(0, 0, 0);
	}

	private static void solve(int start, int cnt, int sum) {

		if (cnt == 7) {
			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (visited[i]) {
						System.out.println(arr[i]);
					}
				}
				System.exit(0);
			}
		}

		for (int i = start; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				solve(i + 1,cnt + 1, sum + arr[i]);
				visited[i] = false;
			}
		}
	}
}
