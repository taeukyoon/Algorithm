import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 9655 돌 게임
 */
public class Main {
    static int n;
    static String[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new String[n + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                dp[i] = "SK";
            }
            if (i % 2 == 0) {
                dp[i] = "CY";
            }
        }
        System.out.println(dp[n]);
    }
}
