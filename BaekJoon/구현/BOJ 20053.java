import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 20053 최소, 최대 2
 */
public class Main {
    static int T, n;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int a = 0; a < n; a++) {
                arr[a] = Integer.parseInt(st.nextToken());

                min = Math.min(min, arr[a]);
                max = Math.max(max, arr[a]);
            }
            System.out.println(min + " " + max);
        }
    }
}
