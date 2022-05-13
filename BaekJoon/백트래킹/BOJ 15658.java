import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 15658 연산자 끼워넣기(2)
 Date: 22-05-13
 Author: taeuk
 */
public class Main {
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] arr, operator;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		operator = new int[4];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		InputOperator(st);

		backtracking(1, arr[0]);
		print();
	}

	private static void print() {
		System.out.println(max);
		System.out.println(min);
	}

	private static void backtracking(int depth, int ans) {
		if (depth == n) {
			max = Math.max(max, ans);
			min = Math.min(min, ans);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0) continue;
			operator[i]--;
			recursion(depth, ans, i);
		}
	}

	private static void recursion(int depth, int ans, int i) {
		switch (i) {
			case 0:
				backtracking(depth + 1, ans + arr[depth]);
				break;
			case 1:
				backtracking(depth + 1, ans - arr[depth]);
				break;
			case 2:
				backtracking(depth + 1, ans * arr[depth]);
				break;
			case 3:
				backtracking(depth + 1, ans / arr[depth]);
				break;
		}
		operator[i]++;
	}

	private static void InputOperator(StringTokenizer st) {
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
	}
}
