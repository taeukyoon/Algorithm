import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 12782 비트 우정지수
 */
public class Main {
    static int t;
    static String n, m;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = st.nextToken();
            m = st.nextToken();

            int zeroCnt = 0;
            int oneCnt = 0;
            for (int j = 0; j < n.length(); j++) {
                if (n.charAt(j) != m.charAt(j)) {
                    if (n.charAt(j) == '0') zeroCnt++;
                    else oneCnt++;
                }
            }
            if (zeroCnt >= oneCnt) sb.append(zeroCnt);
            else sb.append(oneCnt);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
