import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 2661
 Date: 22-05-11
 Author: taeuk
 */
public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		backtracking("");
	}

	private static void backtracking(String str) {
		if (str.length() == n) {
			System.out.println(str);
			System.exit(0);
		}
		for (int i = 1; i <= 3; i++) {
			if (check(str + i)) {
				backtracking(str + i);
			}
		}
	}

	private static boolean check(String str) {
		int length = str.length() / 2;

		for (int i = 1; i <= length; i++) {
			String s = str.substring(str.length() - i * 2, str.length() - i);
			String e = str.substring(str.length() - i, str.length());
			if (s.equals(e)) return false;
		}
		return true;
	}
}
