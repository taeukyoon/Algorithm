import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 BOJ 1746 듣보잡
 Date: 22-05-16
 Author: taeuk
 */
public class Main {
	static int n, m;
	static HashSet<String> set = new HashSet<>();
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				list.add(str);
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
