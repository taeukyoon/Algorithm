import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 BOJ 20155 에너지 드링크
 Greedy
 */
public class Main {
    static int n;
    static Integer[] amount;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        amount = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            amount[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(amount, Collections.reverseOrder());

        double sum = amount[0];
        for (int i = 1; i < amount.length; i++) {
            sum += (double) amount[i] / 2;
        }
        System.out.println(sum);
    }
}
