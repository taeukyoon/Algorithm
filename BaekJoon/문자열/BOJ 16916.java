import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 16916 부분 문자열
 Date: 22-05-17
 Author: taeuk
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String s = br.readLine();
		String p = br.readLine();

		System.out.println(KMP(s, p));
	}

	private static int KMP(String s, String p) {
		int[] pi = makeTable(p);

		int sLength = s.length();
		int pLength = p.length();

		int idx = 0;
		for (int i = 0; i < sLength; i++) {
			while (idx > 0 && s.charAt(i) != p.charAt(idx)) {
				idx = pi[idx - 1];
			}
			if (s.charAt(i) == p.charAt(idx)) {
				if (idx == pLength - 1) {
					return 1;
				}
				idx++;
			}
		}
		return 0;
	}

	private static int[] makeTable(String p) {
		int length = p.length();
		int[] table = new int[length];

		int idx = 0;
		for (int i = 1; i < length; i++) {
			// 연속적으로 일치하지 않음
			while (idx > 0 && p.charAt(i) != p.charAt(idx)) {
				idx = table[idx - 1];
			}

			if (p.charAt(i) == p.charAt(idx)) {
				idx++;
				table[i] = idx;
			}
		}
		return table;
	}
}
