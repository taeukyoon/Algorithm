import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 6996 애너그램
 Date: 22-05-23
 Author: taeuk
 */
public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String s1 = st.nextToken();
			String s2 = st.nextToken();

			char[] a = s1.toCharArray();
			char[] b = s2.toCharArray();

			Arrays.sort(a);
			Arrays.sort(b);

			if (Arrays.equals(a, b)) {
				System.out.println(s1+ " & " +s2 + " are anagrams.");
				continue;
			}
			System.out.println(s1+ " & " +s2 + " are NOT anagrams.");
		}
	}
}
