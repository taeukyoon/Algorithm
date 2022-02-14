import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 9461 파도반 수열
 */
public class Main {
    static int t, n;
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            padovan(n);
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
    public static void padovan(int n) {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }
    }
}
