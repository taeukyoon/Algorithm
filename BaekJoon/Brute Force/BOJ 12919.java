import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 12919 A와 B 2
 Date: 22-08-01
 Author: taeuk
 */
public class Main {
	static String s, t;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        s = br.readLine();
        t = br.readLine();

		System.out.println(dfs(s, t));
    }

	private static int dfs(String s, String t) {
    	if (s.length() == t.length()) {
    		if (s.equals(t)) {
    			return 1;
			}
    		return 0;
		}

    	int ans = 0;

    	if (t.charAt(t.length() - 1) == 'A') {
    		ans += dfs(s, t.substring(0, t.length() - 1));
		}

    	if (t.charAt(0) == 'B') {
    		String str = new StringBuffer(t.substring(1, t.length())).reverse().toString();
    		ans += dfs(s, str);
		}

    	return ans > 0 ? 1 : 0;
	}
}
