import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 17521 Byte Coin
 */
public class Main {
    static int n;
    static long w;
    static int[] coin;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Long.parseLong(st.nextToken());
        coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        long coinCnt = 0;
        for (int i = 1; i < n; i++) {
            if (coin[i] > coin[i - 1]) {
                coinCnt = w / coin[i-1];
                w = coinCnt * coin[i] + w % coin[i-1];
            }
        }
        System.out.println(w);
    }
}
