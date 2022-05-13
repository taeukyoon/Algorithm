import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 19946
 Date: 22-05-13
 Author: taeuk
 */
public class Main {
	static int ans, cnt;
	static int[] correct, temp;
	static final int length = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		correct = new int[length];
		temp = new int[length];

		for (int i = 0; i < length; i++) {
			correct[i] = Integer.parseInt(st.nextToken());
		}

		backtracking(0);

		System.out.println(ans);
	}

	private static void backtracking(int count) {
		if (count == length) {
			cnt = 0;
			checkAnswer();
			checkCount();
			return;
		}

		for (int i = 1; i <= 5; i++) {
			if (checkThreeCount(count, i)) continue;
			temp[count] = i;
			backtracking(count + 1);
		}
	}

	private static boolean checkThreeCount(int count, int i) {
		if (count >= 2) { // 같은거 3개가 인접 x
			if (temp[count - 1] == i && temp[count - 2] == i)
				return true;
		}
		return false;
	}

	private static void checkCount() {
		if (cnt >= 5) {
			ans++;
		}
	}

	private static void checkAnswer() {
		for (int i = 0; i < 10; i++) {
			if (correct[i] == temp[i]) {
				cnt++;
			}
		}
	}
}
