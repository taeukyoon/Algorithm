import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 BOJ 11256 사탕
 */
public class Main {
    static int T, j, n;
    static Integer[] box;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            j = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            box = new Integer[n];
            for (int k = 0; k < n; k++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                box[k] = r * c;
            }

            Arrays.sort(box, Collections.reverseOrder());
            int cnt = 0;
            for (int c = 0; c < n; c++) {
                cnt++;
                j -= box[c];
                if (j < 1) break;
            }
            sb.append(cnt);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
