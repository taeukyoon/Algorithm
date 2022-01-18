import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 2141 우체국
 */
public class Main {
    static long n;
    static Node[] node;
    static class Node implements Comparable<Node>{
        long x, a;

        public Node(long x, long a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x == o.x) {
                return (int) (this.a - o.a);
            }
            return (int) (this.x - o.x);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        node = new Node[(int) n];
        long res = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());

            node[i] = new Node(x, a);
            res += a;
        }
        Arrays.sort(node);

        long sum = 0;
        for (Node n : node) {
            sum += n.a;
            if (sum >= (res + 1) / 2) {
                System.out.println(String.valueOf(n.x));
                break;
            }
        }
    }
}
