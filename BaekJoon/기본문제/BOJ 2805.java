import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 2805 나무 자르기
 binarySearch
 */
public class Main {
    static int n, m;
    static int[] tree;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n];
        int min = 0, max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > max) {
                max = tree[i];
            }
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < tree.length; i++) {
                if (tree[i] - mid > 0) {
                    sum += tree[i] - mid;
                }
            }

            if (sum < m) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
