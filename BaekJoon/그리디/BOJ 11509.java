import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 11509 풍선 맞추기
 */
public class Main {
    static int n;
    static int[] h;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        h = new int[1000001];

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken()) - 1;

            if (h[height + 1] == 0) {
                h[height]++;
                cnt++;
            } else {
                h[height + 1]--;
                h[height]++;
            }
        }
        System.out.println(cnt);
    }
}
