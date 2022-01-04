import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 2417 정수 제곱근
 */
public class Main {
    static long n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        long left = 0, right = n, min = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long val = (long) Math.pow(mid, 2);

            if (val >= 0) {
                if (val >= n) {
                    min = Math.min(min, mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(min);
    }
}
