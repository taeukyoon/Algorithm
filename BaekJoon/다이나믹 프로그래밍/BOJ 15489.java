import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 15489 파스칼 삼각형
 */
public class Main {
    static int r, c, w;
    static int[][] dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        dp = new int[31][31];

        dp[1][1] = 1;
        for (int i = 1; i <= 30; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        int sum = 0;

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < i + 1; j++) {
                sum += dp[r + i][c + j];
            }
        }
        System.out.println(sum);
    }
}
