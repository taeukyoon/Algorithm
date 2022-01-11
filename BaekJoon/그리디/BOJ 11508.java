import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
 BOJ 11508 2 + 1세일
 Greedy
 */
public class Main {
    static int n;
    static Integer[] milk;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        milk = new Integer[n];

        for (int i = 0; i < n; i++) {
            milk[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(milk, Collections.reverseOrder());

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 != 2) {
                res += milk[i];
            }
        }
        System.out.println(res);
    }
}
