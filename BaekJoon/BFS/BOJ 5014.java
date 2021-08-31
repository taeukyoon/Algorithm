import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 5014 스타트링크
 bfs 사용한다.
 */
public class Main{
    static int F, S, G, U, D;
    static int[] map;
    static boolean[] visited;
    static int cnt = 0;
    static Queue<Integer> qu;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[F + 1];
        visited = new boolean[F + 1];
        Arrays.fill(map, -1);
        bfs(S);

        if(map[G] == -1 && S != G) {
            System.out.println("use the stairs");
        } else {
            System.out.println(map[G] + 1);
        }

    }
    public static void bfs(int s) {
        qu = new LinkedList<>();
        qu.offer(s);
        visited[s] = true;

        while(!qu.isEmpty()) {
            cnt++;
            int q = qu.poll();

            if(q == G) {
                return;
            }

            if(q + U <= F && !visited[q + U]) { //최대층 넘지않고 방문하지 않은곳
                qu.offer(q + U);
                map[q + U] = map[q] + 1;
                visited[q + U] = true;
            }
            if(q - D >= 1 && !visited[q - D]) {
                qu.offer(q - D);
                map[q - D] = map[q] + 1;
                visited[q - D] = true;
            }
        }
    }
}