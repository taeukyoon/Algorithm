import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 20164 홀수 홀릭 호석
 */
public class Main {
    static int max = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        process(n, 0);
        System.out.println(min + " " + max);
    }

    public static void process(String n, int cnt) {
        int size = n.length();
        int val;
        cnt += countOdd(n);

        if (size == 1) { //1자리
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        } else if (size == 2) { //2자리수
            val = n.charAt(0) - '0' + n.charAt(1) - '0';
            process(Integer.toString(val), cnt);
        } else {
            for (int i = 1; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    val = sumStr(n.substring(0, i), n.substring(i, j), n.substring(j, size));
                    process(Integer.toString(val), cnt);
                }
            }
        }
    }

    public static int sumStr(String str1, String str2, String str3) {
        int val = Integer.parseInt(str1) + Integer.parseInt(str2) + Integer.parseInt(str3);
        return val;
    }

    public static int countOdd(String n) {
        int odd = 0;
        for (int i = 0; i < n.length(); i++) {
            if ((n.charAt(i) - '0') % 2 == 1) { //홀수
                odd++;
            }
        }
        return odd;
    }
}
