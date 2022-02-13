import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 21317 징검다리 건너기
 */
public class Main {
    static int n, k;
    static int res = Integer.MAX_VALUE;
    static int[][] jump;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        jump = new int[n + 1][2];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jump[i][0] = Integer.parseInt(st.nextToken());
            jump[i][1] = Integer.parseInt(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());
        process(0, 1, false);
        System.out.println(res);
    }

    public static void process(int sum, int idx, boolean flag) {

        if (n == idx) {
            res = Math.min(res, sum);
            return;
        }

        if (idx > n) return;

        process(sum + jump[idx][0], idx + 1, flag);
        process(sum + jump[idx][1], idx + 2, flag);

        if (!flag) {
            process(sum + k, idx + 3, true);
        }
    }
}
