import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1654 랜선 자르기
 Binary Search
 */
public class Main {
    static int k, n;
    static int[] Lan;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        Lan = new int[k];
        long min = 0, max = 0;

        for (int i = 0; i < k; i++) {
            Lan[i] = Integer.parseInt(br.readLine());
            if (Lan[i] > max) { // 최대값 넣어주고
                max = Lan[i];
            }
        }

        max++;
        while (min < max) {
            long mid = (min + max) / 2;
            long cnt = 0;

            for (int i = 0; i < Lan.length; i++) {
                cnt += (Lan[i] / mid);
            }

            if (cnt < n) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
