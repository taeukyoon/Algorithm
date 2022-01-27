import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 16206 롤케이크
 */
public class Main {
    static int n, m, cnt = 0, idx;
    static int[] arr, arr2;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        arr2 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        for (int i = 0; i < n; i++) {
            if (arr[i] == 10) cnt++;
            else if (arr[i] > 10) {
                if (arr[i] % 10 == 0) {
                    cut(arr[i]);
                } else {
                    arr2[idx++] = arr[i];
                }
            }
        }
        if (m > 0) {
            for (int i = 0; i < idx; i++) {
                cut(arr2[i]);
            }
        }
        System.out.println(cnt);
    }
    public static void cut(int arr) {
        if (m == 0) return;
        else {
            cnt++;
            m--;
            int len = arr - 10;

            if (len > 10) {
                cut(len);
            } else {
                if (len == 10) cnt++;
            }
        }
    }
}
