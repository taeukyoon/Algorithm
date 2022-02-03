import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 1463 1로 만들기
 */
public class Main {
    static int n, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cal(n, 0);
        System.out.println(min);
    }

    public static void cal(int num, int cnt) {
        if (num == 1) {
            min = Math.min(min, cnt);
            return;
        }
        if (cnt >= min) return;
        if (num % 3 == 0) {
            cal(num / 3, cnt + 1);
        }
        if (num % 2 == 0) {
            cal(num / 2, cnt + 1);
        }
        cal(num - 1, cnt + 1);
    }
}

