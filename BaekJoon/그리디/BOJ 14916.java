import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 BOJ 14916 거스름돈
 */
public class Main {
    static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (true) {
            if (n % 5 == 0) {
                cnt += n / 5;
                break;
            }
            n -= 2;
            cnt++;
        }
        System.out.println((n < 0) ? -1 : cnt);
    }
}
