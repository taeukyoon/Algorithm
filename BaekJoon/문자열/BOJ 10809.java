import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 BOJ 10809 알파벳 찾기
 Date: 21-05-22
 Author: taeuk
 */
public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		arr = new int[26];
		Arrays.fill(arr, -1);

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (arr[c - 'a'] == -1) {
				arr[c - 'a'] = i;
			}
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
