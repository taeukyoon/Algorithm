import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 2670 연속부최대곱
 */
public class Main {
    static int n;
    static double[] arr, dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new double[n + 1];
        dp = new double[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = 0;

        double max = 0, res = 0;

        for (int i = 1; i <= n; i++) {
            max = arr[i];
            dp[i] = Math.max(dp[i], max);
            for (int j = i + 1; j <= n; j++) {
                max *= arr[j];
                dp[i] = Math.max(dp[i], max);
            }
            res = Math.max(res, dp[i]);
        }

        System.out.printf("%.3f", res);
    }
}
