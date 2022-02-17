import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 BOJ 18352 특정 거리의 도시 찾기
 BFS 
 */
public class Main {
    static int n, m, k, x;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); //단방향 도로
        }
        bfs(x);
    }

    public static void bfs(int x) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> qu = new LinkedList<>();
        dist[x] = 0; // 거리
        qu.add(x);

        while (!qu.isEmpty()) {
            int now = qu.poll();

            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);

                if (dist[next] == -1) { //방문하지 않았다면
                    dist[next] = dist[now] + 1;
                    qu.add(next);
                }
            }
        }

        boolean flag = false;
        for (int i = 0; i <= n; i++) {
            if (dist[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }
}
