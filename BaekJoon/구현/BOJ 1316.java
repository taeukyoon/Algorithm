import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1316 그룹 단어 체커
 */
public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String val = br.readLine();

            if (checkGroup(val)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean checkGroup(String v) {
        boolean[] check = new boolean[99];
        int prev = 0;

        for (int i = 0; i < v.length(); i++) {
            int cur = v.charAt(i);

            if (cur != prev) {
                if (!check[cur - 'a']) {
                    check[cur - 'a'] = true;
                    prev = cur;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
