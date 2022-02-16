import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 BOJ 6118 숨바꼭질
 BFS
 */
public class Main {
    static int n, m, a, b;
    static ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
            nodes[b].add(a);
        }

        bfs(1);
    }

    public static void bfs(int v) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> qu = new LinkedList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        qu.add(v);
        visited[v] = true;
        dist[v] = 0;

        while (!qu.isEmpty()) {
            int now = qu.poll();

            for (int i = 0; i < nodes[now].size(); i++) {
                int nx = nodes[now].get(i);

                if (!visited[nx] && dist[now] + 1 < dist[nx]) {
                    dist[nx] = dist[now] + 1;
                    qu.add(nx);
                    visited[nx] = true;
                }
            }
        }
        int max = -1;
        int cnt = 1;
        int pos = -1;

        for (int i = 1; i <= n; i++) {

            if (max < dist[i]) {
                max = dist[i];
                pos = i;
                cnt = 1;
            } else if (dist[i] == max) {
                cnt++;
            }
        }

        System.out.println(pos + " " + max + " " + cnt);
    }
}
