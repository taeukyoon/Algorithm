import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 16508 전공책
 Date: 22-08-01
 Author: taeuk
 */
public class Main {
	static String t;
	static int n, min = Integer.MAX_VALUE;
	static int[] selCount = new int[26];
	static int[] count = new int[26];
	static ArrayList<Book> list;

	static class Book {
		int price;
		String name;

		public Book(int price, String name) {
			this.price = price;
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public String getName() {
			return name;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = br.readLine();
		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'A']++;
		}
		n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int price = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			list.add(new Book(price, name));
		}

		dfs(0, 0);
		System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
	}

	private static void dfs(int idx, int total) {

		if (idx == n) {
			if (check()) {
				min = Math.min(min, total);
			}
			return;
		}

		for (int i = 0; i < list.get(idx).getName().length(); i++) {
			selCount[list.get(idx).getName().charAt(i) - 'A']++;
		}
		dfs(idx + 1, total + list.get(idx).getPrice());
		for (int i = 0; i < list.get(idx).getName().length(); i++) {
			selCount[list.get(idx).getName().charAt(i) - 'A']--;
		}
		dfs(idx + 1, total);
	}

	private static boolean check() {
		for (int i = 0; i < 26; i++) {
			if (count[i] > selCount[i]) {
				return false;
			}
		}
		return true;
	}
}
