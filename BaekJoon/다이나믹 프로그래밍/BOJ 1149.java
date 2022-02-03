import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1149 RGB거리
 */
public class Main {
    static int n;
    static int[][] dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
        }
        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]),dp[n][2]));
    }
}
