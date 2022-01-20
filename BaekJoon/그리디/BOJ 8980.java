import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 8980 택배
 */
public class Main {
    static int n, c, m;

    static class Node implements Comparable<Node>{
        int s, e, cnt;

        public Node(int s, int e, int cnt) {
            this.s = s;
            this.e = e;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.e == o.e) {
                return this.s - o.s;
            }
            return this.e - o.e;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[m];
        int[] box = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(s, e, cnt);
        }

        Arrays.sort(nodes);
        Arrays.fill(box, c);


        int res = 0;
        for (Node n : nodes) {
            int s = n.s;
            int e = n.e;
            int cnt = n.cnt;

            int min = Integer.MAX_VALUE;
            for (int i = s; i < e; i++) {
                min = Math.min(min, box[i]);
            }

            int load = cnt;
            load = Math.min(load, min);

            res += load;

            for (int i = s; i < e; i++) {
                box[i] -= load;
            }
        }
        System.out.println(res);
    }
}
