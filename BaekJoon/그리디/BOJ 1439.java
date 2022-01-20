import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 1439 뒤집기
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] c = input.toCharArray();
        int size = c.length;

        int zeroCnt = 0;
        int oneCnt = 0;
        if (c[0] == '0') zeroCnt++;
        else oneCnt++;

        for (int i = 1; i < size; i++) {
            if (c[i - 1] != c[i]) {
                if (c[i] == '0') zeroCnt++;
                else oneCnt++;
            }
        }
        System.out.println(Math.min(zeroCnt,oneCnt));
    }
}
