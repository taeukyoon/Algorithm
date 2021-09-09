    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n, r, c, cnt;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solve((int) Math.pow(2, n), 0, 0);
    }
    public static void solve(int n, int y, int x) {
        if(y == r && x == c) {
            System.out.println(cnt);
            System.exit(0);
        }
        if(y <= r && r < (y + n) && x <= c && c < (x + n)) {
            int nn = n / 2;
            solve(nn, x, y);
            solve(nn, y, x + nn);
            solve(nn, y + nn, x);
            solve(nn, y + nn, x + nn);
        } else {
            cnt += n * n;
        }
    }
}