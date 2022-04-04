import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 18311 왕복
 */
public class Main {
    static int n;
    static long k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            k -= arr[i];
            if (k < 0) {
                System.out.println(i);
                flag = true;
                break;
            }
        }

        if (!flag) {
            for (int i = n; i >= 1; i--) {
                k -= arr[i];
                if (k < 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
