import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 1259 팰린드롬수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("0")) System.exit(0);

            String[] str1 = new String[str.length()];
            String[] str2 = new String[str.length()];

            //배열로
            for (int i = 0; i < str.length(); i++) {
                str1[i] = str.substring(i, i + 1);
            }

            //reverse
            for (int i = 0; i < str.length(); i++) {
                str2[i] = str1[str.length() - i - 1];
            }

            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str1[i].equals(str2[i])) cnt++;
            }

            if (cnt == str.length()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
