import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 9933 민균이의 비밀번호
 Date: 22-05-23
 Author: taeuk
 */
public class Main {
	static int n;
	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			String reverse = new StringBuffer(s).reverse().toString();

			if (list.contains(reverse) || s.equals(reverse)) {
				System.out.println(s.length() + " " + s.charAt(s.length() / 2));
				return;
			}
			list.add(s);
		}
	}
}
