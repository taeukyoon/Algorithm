import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 1159 농구 경기
 Date: 22-05-22
 Author: taeuk
 */
public class Main {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[26];

		for (int i = 0; i < n; i++) {
			char c = br.readLine().charAt(0);

			arr[c - 'a']++;
		}

		boolean flag = false;
		for (int i = 0; i < 26; i++) {
			if (arr[i] >= 5) {
				flag = true;
				System.out.print((char)(i + 'a'));
			}
		}
		if (!flag) System.out.println("PREDAJA");
	}
}
