import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 14502 연구소
 Date: 21-10-19
 */
public class Main{
    static int N, M;
    static int[][] map, copyMap;
    static int res = Integer.MIN_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Virus {
        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(res);
    }
    public static void dfs(int depth) {
        if(depth == 3) {
            bfs();
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void bfs() {
        Queue<Virus> qu = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copyMap[i][j] == 2) {
                    qu.add(new Virus(i, j));
                }
            }
        }

        while (!qu.isEmpty()) {
            Virus v = qu.poll();

            for(int k = 0; k < 4; k++) {
                int nx = v.x + dx[k];
                int ny = v.y + dy[k];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        qu.add(new Virus(nx, ny));
                    }
                }
            }
        }
        safe(copyMap);
    }
    public static void safe(int[][] copyMap) {
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        res = Math.max(res, cnt);
    }
}