import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 14503 로봇청소기
 */
public class Main{
    static int N, M, r, c, d, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean flag = false;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        clean(r, c, d);
        System.out.println(cnt);
    }
    public static void clean(int r, int c, int d) {
        if(!visited[r][c]) {
            visited[r][c] = true;
            cnt++;
        }

        for(int k = 0; k < 4; k++) {
            d = rotation(d);
            int nx = r + dx[d];
            int ny = c + dy[d];

            if(map[nx][ny] == 0 && !visited[nx][ny]) {
                clean(nx, ny, d);
                flag = true;
                break;
            }
        }

        if(!flag) {
            int nx = r - dx[d];
            int ny = c - dy[d];

            if(map[nx][ny] == 0) {
                clean(nx, ny, d);
            }
        }
    }
    public static int rotation(int d) {
        if(d == 0) return 3;
        else if(d == 1) return 0;
        else if(d == 2) return 1;
        else return 2;
    }
}