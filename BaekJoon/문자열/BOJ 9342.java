import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 9342 염색체
 Date: 22-05-16
 Author: taeuk
 */
public class Main {
	static int t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		String regex = "^[A-F]?A+F+C+[A-F]?$";

		while (t-- > 0) {
			String str = br.readLine();
			System.out.println((str.matches(regex)) ? "Infected!" : "Good");
		}
	}
}
