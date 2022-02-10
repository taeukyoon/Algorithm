import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 15486 퇴사 2
 */
public class Main {
    static int n;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 2][2];
        dp = new int[n + 2];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr[i][0] = T;
            arr[i][1] = P;
        }

        int max = -1;
        for (int i = 1; i < n + 2; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int next = i + arr[i][0];
            if (next <= n + 1) {
                dp[next] = Math.max(dp[next], arr[i][1] + max);
            }
        }
        System.out.println(dp[n+1]);
    }
}
