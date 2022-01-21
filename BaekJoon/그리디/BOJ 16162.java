import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 16162 가희 3단 고음
 */
public class Main {
    static int n, a, d;
    static int[] player;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        player = new int[n];

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            player[i] = Integer.parseInt(st.nextToken());

            if (player[i] == a) {
                cnt++;
                a += d;
            }
        }
        System.out.println(cnt);

    }
}
