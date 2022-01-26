import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 17615 볼 모으기
 */
public class Main {
    static int N, red, blue;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        boolean flag = false;
        char start = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (start == input.charAt(i) && !flag) {
                continue;
            } else {
                flag = true;
                if (input.charAt(i) == 'R') red++;
                else blue++;
            }
        }
        int min1 = Math.min(red, blue);

        red = 0; blue = 0;
        flag = false;
        char end = input.charAt(N - 1);
        for (int i = input.length() - 2; i >= 0; i--) {
            if (end == input.charAt(i) && !flag) {
                continue;
            } else {
                flag = true;
                if (input.charAt(i) == 'R') red++;
                else blue++;
            }
        }
        int min2 = Math.min(red, blue);

        System.out.println((Math.min(min1, min2)));
    }
}
