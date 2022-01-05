import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 2110 공유기 설치
 Binary Search
 */
public class Main {
    static int n, c, res;
    static int[] home;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        home = new int[n];

        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int min = 1, max = home[n - 1] - home[0]; // 최소 거리의 최소거리 최대거리
        while (min <= max) {
            int mid = (min + max) / 2;
            int start = home[0];
            int cnt = 1; // 이미 1번에서 시작함 개수 1개

            for (int i = 1; i < home.length; i++) {
                int distance = home[i] - start; // 거리

                if (distance >= mid) {
                    cnt++;
                    start = home[i];
                }
            }

            if (cnt >= c) { // 공유기가 더많다 -> 거리를 늘리자
                res = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(res);
    }
}
