import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 2285 우체국
 */
public class Main {
    static int n;
    static Node[] nodes;

    static class Node implements Comparable<Node> {
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
        nodes = new Node[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());

            nodes[i] = new Node(x, a);
            sum += a;
        }
        Arrays.sort(nodes);

        long tmp = 0;
        for (Node n : nodes) {
            tmp += n.a;
            if (tmp >= (sum + 1) / 2) {
                System.out.println(String.valueOf(n.x));
                break;
            }
        }
    }
}
