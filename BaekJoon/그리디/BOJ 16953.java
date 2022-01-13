import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 16953
 */
public class Main {
    static int a, b;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (b != a) {
            if (b < a) {
                System.out.println(-1);
                System.exit(0);
            }

            if (b % 2 == 0) b /= 2;
            else if (b % 10 == 1) b /= 10;
            else {
                System.out.println(-1);
                System.exit(0);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
