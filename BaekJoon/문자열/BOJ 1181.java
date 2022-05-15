import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
 BOJ 1181 단어 정렬
 Date: 22-05-15
 Author: taeuk
 */
public class Main {
	static int n;
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		sort();

		List<String> answer = list.stream().distinct().collect(toList());

		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

	private static void sort() {
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return Integer.compare(o1.length(), o2.length());
			}
		});
	}
}
