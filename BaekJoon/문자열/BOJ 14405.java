import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 14405 피카츄
 Date: 22-05-24
 Author: taeuk
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String s = br.readLine();

		String result = s.replaceAll("pi|ka|chu","");
		if (result.equals("")) {
			System.out.println("YES");
			System.exit(0);
		}
		System.out.println("NO");
	}
}
