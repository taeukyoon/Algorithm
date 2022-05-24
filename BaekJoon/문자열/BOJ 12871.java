import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 12871 무한 문자열
 Date: 22-05-24
 Author: taeuk
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        String t = br.readLine();

        String S = s;
        String T = t;

        if (s.length() != t.length()) {
        	// 최소 공배수
        	int length = lcm(s.length(), t.length());

        	while (S.length() != length) S += s;
        	while (T.length() != length) T += t;
		}

        if (S.equals(T)) {
			System.out.println(1);
			System.exit(0);
		}
		System.out.println(0);
	}

	private static int lcm(int length, int length1) {
    	return length * length1 / gcd(length, length1);
	}

	private static int gcd(int length, int length1) {
		while (length1 > 0) {
			int tmp = length;
			length = length1;
			length1 = tmp % length1;
		}

		return length;
	}
}
