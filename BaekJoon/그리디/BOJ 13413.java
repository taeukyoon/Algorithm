import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 13413 오셀로 재배치
 */
public class Main {
    static int T, n;
    static char[] c;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String input2 = br.readLine();

            int wCnt = 0;
            int bCnt = 0;
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) != input2.charAt(j)) {
                    if (input.charAt(j) == 'W') wCnt++;
                    else bCnt++;
                }
            }
            sb.append(Integer.max(wCnt, bCnt)).append('\n');
        }
        System.out.println(sb);
    }
}
