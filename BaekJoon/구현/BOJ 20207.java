import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 20207 달력
 */
public class Main {
    static int n, s, e;
    static int[] list;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new int[366];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            for (int j = s; j <= e; j++) {
                list[j] += 1;
            }
        }

        int max = 0;
        int time = 0;
        int res = 0;
        for (int i = 1; i <= 365; i++) {
            if (list[i] > 0) {
                time++;
                max = Math.max(max, list[i]);
            } else {
                res += (time * max);
                time = 0;
                max = 0;
            }
        }
        res += (time * max);
        System.out.println(res);
    }
}
