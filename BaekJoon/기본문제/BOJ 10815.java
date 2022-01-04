import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 10815
 이분탐색
 */
public class Main {
    static int n, m;
    static int[] a;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
    public static int binarySearch(int key) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int midIdx = (left + right) / 2;
            int selVal = a[midIdx];

            if (key > selVal) {
                left = midIdx + 1;
            } else if (key < selVal) {
                right = midIdx - 1;
            } else {
                return midIdx;
            }
        }
        return -1;
    }
}
