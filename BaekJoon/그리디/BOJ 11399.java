import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 11399 ATM
 Greedy
 */
public class Main {
    static int n;
    static int[] time;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        time = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += time[i];
            res += sum;
        }
        System.out.println(res);
    }
}
