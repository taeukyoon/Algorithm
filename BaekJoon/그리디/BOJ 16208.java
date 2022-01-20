import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 16208 귀찮음
 */
public class Main {
    static int n;
    static int[] stick;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        stick = new int[n];

        st = new StringTokenizer(br.readLine());
        long all = 0;
        for (int i = 0; i < n; i++) {
            stick[i] = Integer.parseInt(st.nextToken());
            all += stick[i];
        }
        Arrays.sort(stick);

        long sum = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (all != stick[i]) {
                    long temp = stick[i];
                    all -= temp;
                    sum += all * stick[i];
                }
            }
            break;
        }
        System.out.println(sum);
    }
}
