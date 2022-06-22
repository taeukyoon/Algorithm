import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int landNum = 2;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, 1};
    static int result = Integer.MAX_VALUE;
    static Queue<Pair> qu;

    static class Pair {

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        int x, y, cnt;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    numbering(i, j);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] >= 2) {
                    visited = new boolean[N][N];
                    bfs(i, j);
                }
            }
        }
        System.out.println(result);
    }
    public static void numbering(int x, int y) {
        qu = new LinkedList<>();
        qu.offer(new Pair(x, y, 0));
        visited[x][y] = true;
        map[x][y] = landNum;
        while(!qu.isEmpty()) {
            Pair p = qu.poll();
            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if((nx >= 0 && ny >= 0 && nx < N && ny < N) && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = landNum;
                    qu.offer(new Pair(nx, ny, 0));
                }
            }
        }
        landNum++;
    }
    public static void bfs(int x, int y) {
        qu = new LinkedList<>();
        qu.offer(new Pair(x, y, 0));
        visited[x][y] = true;
        int current = map[x][y];
        while(!qu.isEmpty()) {
            Pair p = qu.poll();
            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if((nx >= 0 && ny >= 0 && nx < N && ny < N) && !visited[nx][ny] && map[nx][ny] != current ) {
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 0) {
                        qu.offer(new Pair(nx, ny, p.cnt + 1));
                    } else {
                        result = Math.min(result, p.cnt);
                    }
                }
            }
        }
    }
}