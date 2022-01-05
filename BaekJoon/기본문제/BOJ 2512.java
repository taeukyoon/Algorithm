import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 2512 예산
 Binary Search
 */
public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        long left = 0, right = arr[n - 1], max = Integer.MIN_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= mid) sum += mid;
                else sum += arr[i];
            }

            if (sum > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
                max = Math.max(max, left);
            }
        }
        System.out.println(max - 1);
    }
}
