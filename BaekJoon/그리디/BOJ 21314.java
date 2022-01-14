import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 21314 민겸 수
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int size = s.length();

        System.out.println(findMax(s, size));
        System.out.println(findMin(s, size));
    }
    public static String findMin(String str, int s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            if (str.charAt(i) == 'M') {
                int k = i;
                while (s > k && str.charAt(k) == 'M') {
                    k++;
                }
                sb.append(1);
                for (; i + 1 < k; i++) {
                    sb.append(0);
                }
                i = k - 1;
            } else {
                sb.append(5);
            }
        }
        return sb.toString();
    }

    public static String findMax(String str, int s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            if (str.charAt(i) == 'M') {
                int k = i;
                while (s > k && str.charAt(k) == 'M') {
                    k++;
                }
                if (k == s) {
                    for (; i < k; i++) {
                        sb.append(1);
                    }
                } else {
                    sb.append(5);
                    for (; i < k; i++) {
                        sb.append(0);
                    }
                }
                i = k;
            } else {
                sb.append(5);
            }
        }
        return sb.toString();
    }
}
