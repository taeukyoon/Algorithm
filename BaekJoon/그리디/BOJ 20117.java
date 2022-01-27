import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 20117 호반우 상인의 이상한 품질 계산법
 */
public class Main {
    static int n;
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

        int res = 0;
        for (int i = n - 1; i >= (int) ((n+1) / 2); i--) {
            res += arr[i];
        }
        System.out.println((n % 2 ==0) ? res * 2 :res * 2 + arr[n/2]);
    }
}
