import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 5597 과제 안 내신 분?
 */
public class Main {
    static boolean[] check = new boolean[31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 28; i++) {
            int num = Integer.parseInt(br.readLine());
            check[num] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }
}
