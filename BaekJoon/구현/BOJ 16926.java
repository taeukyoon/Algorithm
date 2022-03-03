import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 16926 배열 돌리기1
 */
public class Main {
    static int n, m, r;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int z = Math.min(n, m) / 2;
        for (int i = 0; i < r; i++) {
            rotate(z);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int z) {
        for (int i = 0; i < z; i++) {
            int x = i;
            int y = i;
            int dir = 0;
            int tmp = map[i][i];

            while (dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= i && ny >= i && nx < n - i && ny < m - i) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                } else dir++;
            }
            map[i + 1][i] = tmp;
        }
    }
}
