import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 11365 !밀비 급일
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        while (true) {
            String str = br.readLine();
            if (str.equals("END"))  break;
            sb = new StringBuilder(str);
            String reverse = sb.reverse().toString();
            System.out.println(reverse);
        }
    }
}
