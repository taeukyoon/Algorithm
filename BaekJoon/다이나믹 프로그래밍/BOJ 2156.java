import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 2156 포도주 시식
 */
public class Main {
    static int n;
    static int[] grape, dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grape = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = grape[1];
        if (n > 1) {
            dp[2] = grape[1] + grape[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grape[i], dp[i - 3] + grape[i - 1] + grape[i])); //ooo, oxo, xoo
        }
        System.out.println(dp[n]);
    }
}
