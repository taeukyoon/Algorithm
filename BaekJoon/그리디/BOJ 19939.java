import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 19939 박 터뜨리기
 */
public class Main {
    static int n, k;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= k; i++) {
            n -= i;
        }
        if (n >= 0) {
            if (n % k > 0) {
                System.out.println(k);
            } else {
                System.out.println(k - 1);
            }
        } else {
            System.out.println(-1);
        }
    }
}
