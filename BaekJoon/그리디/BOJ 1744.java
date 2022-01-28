import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 BOJ 1744 수 묶기
 */

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long sum = 0;
        int left = 0, right = n - 1;

        for (; left < right; left += 2) {
            if (arr[left] < 1 && arr[left+1] < 1) {
                sum += (long) arr[left] * arr[left+1];
            } else break;
        }

        for (; right > left; right -= 2) {
            if (arr[right] > 1 && arr[right-1] > 1) {
                sum += (long) arr[right] * arr[right-1];
            } else break;
        }

        for (; right >= left; right--) {
            sum += (long) arr[right];
        }
        System.out.println((n == 1) ? arr[0] : sum);
    }
}
