import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 BOJ 1012 유기농 배추!
 BFS 사용 DFS 사용도 가능하다.
 */
class Main{
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pair> qu;
    static class Pair{
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int c = 0; c < T; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                map[p1][p2] = 1;
            }

            int cnt = 0;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void bfs(int x, int y) {
        qu = new LinkedList<>();
        Pair p = new Pair(x, y);
        qu.add(p);
        while (!qu.isEmpty()) {
            Pair pair = qu.poll();
            visited[pair.x][pair.y] = true;
            for(int k = 0; k < 4; k++) {
                int nx = pair.x + dx[k];
                int ny = pair.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= M || ny>=N) continue;
                if(map[nx][ny] == 0 || visited[nx][ny])continue;
                qu.add(new Pair(nx,ny));
                visited[nx][ny] = true;
            }
        }
    }
}