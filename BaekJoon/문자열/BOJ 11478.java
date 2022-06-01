import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 BOJ 11478
 Date: 22-06-01
 Author: taeuk
 */
public class Main {
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		set = new HashSet<>();
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String substring = str.substring(i, j);
				set.add(substring);
			}
		}
		System.out.println(set.size());
	}
}
