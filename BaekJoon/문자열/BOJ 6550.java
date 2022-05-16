import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 6550 부분 문자열
 Date: 22-05-16
 Author: taeuk
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
        	String str = br.readLine();
        	if (str == null) break;
        	st = new StringTokenizer(str, " ");
        	String s = st.nextToken();
			String t  =st.nextToken();

			int index = 0;
			for (int i = 0; i < t.length(); i++) {
				if (s.charAt(index) == t.charAt(i)) {
					index++;
				}
				if (index == s.length()) {
					break;
				}
			}

			System.out.println((index == s.length()) ? "Yes" : "No");
		}
    }
}
