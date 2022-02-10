import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 1106 호텔
 */
public class Main {
    static int c, n;
    static int[] dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        dp = new int[c + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for (int j = num; j < c + 101; j ++) {
                if (dp[j - num] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], cost + dp[j - num]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = c; i < c + 101; i++) {
            res = Math.min(res, dp[i]);
        }
        System.out.println(res);
    }
}
