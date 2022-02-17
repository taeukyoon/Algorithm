import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 2302 극장 좌석
 DP
 */
public class Main {
    static int n, m;
    static int[] dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        int res = 1;
        int seat = 0;
        for (int i = 0; i < m; i++) {
            int vip = Integer.parseInt(br.readLine());
            res *= dp[vip - 1 - seat];
            seat = vip;
        }
        res *= dp[n - seat];

        System.out.println(res);
    }
}
