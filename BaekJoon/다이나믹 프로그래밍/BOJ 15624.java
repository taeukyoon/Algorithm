import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 15624 피보나치 수 7
 */
public class Main {
    static int n;
    static long[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        fibo = new long[n + 2];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++)  {
            fibo[i] = fibo[i - 1] + fibo[i - 2]  % 1000000007;
        }

        System.out.println(fibo[n] % 1000000007);
    }
}
