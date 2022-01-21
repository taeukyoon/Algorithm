import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1817 짐 챙기는 숌
 */
public class Main {
    static int n, m;
    static int[] weight;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        weight = new int[n];


        if (n == 0) {
            System.out.println(0);
            return;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += weight[i];
            if (sum > m) {
                cnt++;
                sum = weight[i];
            }
        }
        System.out.println(cnt);
    }
}
