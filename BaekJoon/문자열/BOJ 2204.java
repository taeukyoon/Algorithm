import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 BOJ 2204 도비의 난독증 테스트
 Date: 22-05-24
 Auhor: taeuk
 */
public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0) break;
			ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(br.readLine());
			}
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.toLowerCase().compareTo(o2.toLowerCase());
				}
			});

			System.out.println(list.get(0));
		}
	}
}
