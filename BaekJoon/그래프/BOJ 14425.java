import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 BOJ 14425
 Date: 22-07-23
 Author: taeuk
 */
public class Main {
	static int n, m;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			set.add(s);
		}

		int count = 0;
		for (int i = 0; i < m; i++) {
			String val = br.readLine();

			if (set.contains(val))
				count++;
		}
		System.out.println(count);
	}
}
