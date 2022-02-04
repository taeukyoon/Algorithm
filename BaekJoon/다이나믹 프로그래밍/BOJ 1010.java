import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1010 다리 놓기
 */
public class Main {
    static int t, n, m;
    static int[][] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dp = new int[n + 1][m + 1];

            for (int a = 2; a <= n; a++) {
                dp[a][1] = 0;
            }

            for (int b = 1; b <= m; b++) {
                dp[1][b] = b;
            }

            for (int a = 2; a <= n; a++) {
                for (int b = 2; b <= m; b++) {
                    dp[a][b] = dp[a][b - 1] + dp[a - 1][b - 1];
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
