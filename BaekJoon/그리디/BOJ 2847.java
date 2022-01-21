import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 BOJ 2847 게임을 만든 동준이
 */
public class Main {
    static int n;
    static int[] score;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        for (int i = n - 1; i > 0; i--) {
            if (score[i] <= score[i - 1]) {
                res += Math.abs(score[i] - score[i - 1]) + 1;
                score[i - 1] = score[i] - 1;
            }
        }
        System.out.println(res);
    }
}
