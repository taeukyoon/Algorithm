import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 17128 소가 정보섬에 올라온 이유
 */
public class Main {
    static int n, q;
    static int[] cow, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        cow = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cow[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = cow[i] * cow[(i + 1) % n] * cow[(i + 2) % n] * cow[(i + 3) % n];
            sum += (long) dp[i];
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (--num == -1) num = n - 1;

            for (int j = 0; j < 4; j++) {
                dp[num] = -dp[num];
                sum += 2L * dp[num];
                if (--num == -1) num = n - 1;
            }
            System.out.println(sum);
        }
    }
}
