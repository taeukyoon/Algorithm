import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 3079 입국심사
 Binary Search
 */
public class Main {
    static int n, m;
    static int[] time;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(time);

        long res = binarySearch();
        System.out.println(res);
    }

    public static long binarySearch() {
        long left = 0, right = (long) m * time[n - 1], min = Long.MAX_VALUE; // m명이 통과하는데 최소 시간과 최대시간

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i : time) {
                long peopleCnt = mid / i; // 사람의수

                if (sum >= m) {
                    break;
                }
                sum += peopleCnt;
            }

            if (sum >= m) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }
}
