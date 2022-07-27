import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 2231 분해합
 Date: 22-07-27
 Author: taeuk
 */
public class Main {
	static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
			String val = Integer.toString(i);
			int sum = 0;

			for (int j = 0; j < val.length(); j++) {
				sum += Character.getNumericValue(val.charAt(j));
			}
			sum += Integer.parseInt(val);

			if (sum == n) {
				System.out.println(val);
				break;
			}
			if (i == n)
				System.out.println(0);
		}
    }
}
