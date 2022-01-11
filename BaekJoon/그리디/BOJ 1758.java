import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
 BOJ 1758 알바생 강호
 Greedy
 */
public class Main {
    static int n;
    static Integer[] tips;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tips = new Integer[n];

        for (int i = 0; i < n; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips, Collections.reverseOrder());

        long res = 0;
        for (int i = 0; i < n; i++) {
            int tip = tips[i] - ((i + 1) - 1);

            if (tip > 0) {
                res += tip;
            }
        }
        System.out.println(res);
    }
}
