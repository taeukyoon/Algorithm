import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 20154 이 구역의 승자는 누구?!
 Date: 22-05-15
 Author: taeuk
 */
public class Main {
	static int[] arr;
	static int[] alpha = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();
		int length = str.length();

		arr = new int[length]; // 알파벳 개수

		for (int i = 0; i < length; i++) { // ok
			arr[i] = alpha[str.charAt(i) - 'A'];
		}

		int ans = 0;
		for (int i = 0; i < length; i++) {
			ans += arr[i];
			if (ans > 10)
				ans %= 10;
		}

		System.out.println((ans % 2 == 1) ? "I'm a winner!" : "You're the winner?");
	}
}
