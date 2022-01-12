import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1541 잃어버린 괄호
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        // 55, 50 + 40

        int sum = Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            int val = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while (st2.hasMoreTokens()) {
                val += Integer.parseInt(st2.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = val;
            } else {
                sum -= val;
            }
        }
        System.out.println(sum);
    }
}
