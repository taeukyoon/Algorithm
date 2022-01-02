import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 21610 마법사 상어와 비바리기
 */
public class Main {
    static int n, m, res, dir, distance;
    static int[][] map, move;
    static boolean[][] visited;
    static ArrayList<Air> list;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        move = new int[m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            move[i][0] = Integer.parseInt(st.nextToken());
            move[i][1] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        list.add(new Air(n - 1, 0));
        list.add(new Air(n - 1, 1));
        list.add(new Air(n - 2, 0));
        list.add(new Air(n - 2, 1));


        for (int i = 0; i < m; i++) {
            visited = new boolean[n][n];
            int dir = move[i][0];
            int distance = move[i][1];
            move(dir, distance);
            waterCopy();
            cloud();
        }
        sum();
        System.out.println(res);
    }

    public static int sum() {
        res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += map[i][j];
            }
        }
        return res;
    }

    public static void cloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2 && !visited[i][j]) {
                    list.add(new Air(i, j));
                    map[i][j] -= 2;
                }
            }
        }
    }

    public static void waterCopy() {
        for (Air air : list) {
            int cnt = 0;
            for (int k = 2; k <= 8; k += 2) { // 대각선만
                int x = air.x + dx[k];
                int y = air.y + dy[k];
                if (check(x, y) && map[x][y] > 0) {
                    cnt++;
                }
            }
            map[air.x][air.y] += cnt;
        }
        list.clear();
    }
    public static void move(int dir, int distance) {
        for (Air air : list) {
            int nx = (air.x + n + dx[dir] * distance % n) % n;
            int ny = (air.y + n + dy[dir] * distance % n) % n;

            visited[nx][ny] = true;
            map[nx][ny] += 1;
            air.x = nx;
            air.y = ny;
        }
    }

    public static boolean check(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
    static class Air {
        int x, y;

        public Air(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}
