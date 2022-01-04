import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

/*
 BOJ 10815-2
 이분탐색 말고 다른방법
 */
public class Main {
    static int n, m;
    static BitSet bitSet = new BitSet(20000001);
    static int offset = 10000000;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bitSet.set(Integer.parseInt(st.nextToken()) + offset);
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(bitSet.get(Integer.parseInt(st.nextToken()) + offset) ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}
