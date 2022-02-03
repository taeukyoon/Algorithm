import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 2579 계단 오르기
 */
public class Main {
    static int n;
    static int[] score, dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[301];
        score = new int[301];

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        dp[3] = Math.max(score[1], score[2]) + score[3];

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }
        System.out.println(dp[n]);
    }
}
