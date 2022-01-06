import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 11663 선분 위의 점
 Binary Search
 */
public class Main {
    static int n, m;
    static int[] dot;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dot = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dot[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dot);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int res = binarySearch(s, e);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int s, int e) {
        int left = 0, right = dot.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (dot[mid] > e) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int endIdx = right + 1;
        left = 0; right = dot.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (dot[mid] < s) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int firstIdx = left;
        return endIdx - firstIdx;
    }
}
