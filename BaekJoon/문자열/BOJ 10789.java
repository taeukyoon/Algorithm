import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 10789 세로읽기
 Date: 22-05-13
 Author: taeuk
 */
public class Main {
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		arr = new char[5][15]; // 다섯개의 단어, 단어당 15개까지 가능
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		vertical(sb);
		System.out.println(sb);
	}

	private static void vertical(StringBuilder sb) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] == ' ' || arr[j][i] == '\0')
					continue;
				sb.append(arr[j][i]);
			}
		}
	}
}
