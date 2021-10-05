import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, M, cnt;
    static int min = Integer.MAX_VALUE;
    static Node[] nodes = new Node[8];
    static int[][] dir = {
            {},
            {1},
            {1, 3},
            {0, 1},
            {0, 1, 3},
            {0, 1, 2, 3}
    };
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    nodes[cnt++] = new Node(i, j, map[i][j]);
                }
            }
        }
        solve(0, map);
        System.out.println(min);
    }
    public static void solve(int idx, int[][] arr) {
        if(idx == cnt) {
            int res = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == 0) {
                        res++;
                    }
                }
            }
            min = Math.min(min, res);
            return;
        }
        Node node = nodes[idx];

        for(int k = 0; k < 4; k++) {
            int[][] map = copy(arr);

            for(int i = 0; i < dir[node.c].length; i++) {
                int nd = (dir[node.c][i] - k + 3) % 4;
                int nx = node.x;
                int ny = node.y;

                while (true) {
                    nx += dx[nd];
                    ny += dy[nd];
                    if(isRange(nx, ny) || map[nx][ny] == 6) break;
                    map[nx][ny] = 7;
                }
            }
            solve(idx + 1, map);
        }
    }
    public static boolean isRange(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }
    public static int[][] copy (int[][] arr) {
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = arr[i][j];
            }
        }
        return map;
    }
    static class Node {

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        int x, y, c;
    }
}