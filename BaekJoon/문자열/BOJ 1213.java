import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1213
 Date: 22-05-26
 Author: taeuk
 */
public class Main {
	static int[] alpha = new int[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			alpha[c - 'A']++;
		}

		int mid = 0, cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 != 0) { // 개수
				mid = i;
				cnt++;
			}
		}

		StringBuilder sb = new StringBuilder();
		if ((str.length() % 2 == 1 && cnt > 1) || (str.length() % 2 == 0 && cnt > 0)) {
			sb.append("I'm Sorry Hansoo");
		} else {
			String res = "";
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < alpha[i] / 2; j++) {
					res += (char)(i + 'A');
				}
			}
			String reverse = new StringBuilder(res).reverse().toString();
			// 짝수에서 중간에 1개의 단어
			if (cnt == 1) {
				res += (char)(mid + 'A');
			}
			sb.append(res + reverse);
		}
		System.out.println(sb);
	}
}

