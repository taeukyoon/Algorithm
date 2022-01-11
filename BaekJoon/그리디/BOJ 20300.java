import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 20300 서강근육맨
 Greedy
 */
public class Main {
    static int n, m;
    static long[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long m = 0;
        for (int i = 0; i < n / 2; i++) {
            int minus = (arr.length % 2 == 0) ? 1 : 2;
            int j = arr.length - 1 - minus;
            if (i == j) continue;
            long sum = arr[i] + arr[j];
            m = Math.max(m, sum);
        }
        System.out.println(m);
    }
}
