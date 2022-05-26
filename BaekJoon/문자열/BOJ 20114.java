import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 20114 미아 노트
 Date: 22-05-26
 Author: taeuk
 */
public class Main {
	static int n, h, w;
	static char[] ch;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		int length = n * w;
		ch = new char[n];
		Arrays.fill(ch, '?');

		for (int i = 0; i < h; i++) {
			String str = br.readLine();
			for (int j = 0; j < length; j++) {
				char c = str.charAt(j);

				if (c == '?') continue;
				else ch[j / w] = c;
			}
		}

		for (char c : ch) {
			System.out.print(c);
		}
	}
}
