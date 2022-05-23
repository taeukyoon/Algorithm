import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 11655 ROT13
 Date: 22-05-23
 Author: taeuk
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// 대문자 -> 소문자
			if (c >= 'A' && c <= 'Z') {
				c += 13;
				if (c > 'Z') {
					int tmp = c - 'Z';
					c = 'A' - 1;
					c += tmp;
				}
			} else if (c >= 'a' && c <= 'z') {
				c += 13;
				if (c > 'z') {
					int tmp = c - 'z';
					c = 'a' - 1;
					c += tmp;
				}
			}
			sb.append(c);
		}
		System.out.println(sb);
	}
}
