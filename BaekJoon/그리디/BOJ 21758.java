import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 21785
 */
public class Main {
    static int n;
    static int[] arr, sum;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        sum = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i-1];
        }

        int res = 0;
        //bee bee    꿀
        for (int i = 2; i <= n-1; i++) {
            int tmp = sum[n] - arr[1] + sum[n] - sum[i] - arr[i];
            res = Math.max(res, tmp);
        }


        //bee 꿀 bee
        for (int i = 2; i <= n-1; i++) {
            int tmp = sum[n - 1] - sum[i - 1] + sum[i] - sum[1];
            res = Math.max(res, tmp);
        }

        //꿀 bee bee
        for (int i = 2; i <= n-1; i++) {
            int tmp = sum[n - 1] + sum[i - 1] - arr[i];
            res = Math.max(res, tmp);
        }
        System.out.println(res);
    }
}
