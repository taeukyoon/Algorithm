import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 BOJ 19532 수학은 비대강의입니다
 */
public class Main {
    static int a, b, c, d, e, f;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (a*i + b*j == c && d*i + e*j == f) {
                    sb.append(i).append(" ").append(j);
                }
            }
        }
        System.out.println(sb);
    }
}
