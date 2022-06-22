import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 BOJ 2468 안전 영역
 1. 물에 잠기지 않는 안전한 영역의 최대개수
 2. tranMap에서 높이 이하면 0, 높이 이상이면 1로 표시하여 dfs
 */
public class Main{
    static int[][] map, transMap;
    static boolean[][] visited;
    static int n, cnt, max;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 1;
        for(int i = 1; i <= 100; i++) {
            transMap = new int[n][n];
            visited = new boolean[n][n];
            cnt = 0;

            for(int a = 0; a < n; a++) {
                for(int b = 0; b < n; b++) {
                    if(map[a][b] <= i) {
                        transMap[a][b] = 0;
                    }
                    else transMap[a][b] = 1;
                }
            }
            for(int a = 0; a < n; a++) {
                for(int b = 0; b < n; b++) {
                    if(transMap[a][b] == 1 && !visited[a][b]) {
                        dfs(a, b);
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(transMap[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx,ny);
                }
            }
        }
    }
}