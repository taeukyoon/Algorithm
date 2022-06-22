import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 BOJ 7569 토마토
 */
class Main{
    static int M, N, H;
    static int[][][] map;
    static boolean[][][] visited;
    static Queue<Three> qu;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    static class Three {
        public Three(int z, int y, int x) {
            this.x = x; //가로
            this.y = y; //세로
            this.z = z; //면
        }

        int x, y, z;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        qu = new LinkedList<Three>();

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < M; c++) {
                    map[i][j][c] = Integer.parseInt(st.nextToken());
                    if(map[i][j][c] == 1) {
                        qu.add(new Three(i, j, c));
                    }
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs() {
        while(!qu.isEmpty()) {
            Three t = qu.poll();
            int x = t.x;
            int y = t.y;
            int z = t.z;

            for(int k = 0; k < 6; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nz = z + dz[k];

                if(nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                    if(map[nz][ny][nx] == 0) {
                        qu.add(new Three(nz, ny, nx));
                        map[nz][ny][nx] = map[z][y][x] + 1;
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;


        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int c = 0; c < M; c++) {
                    if(map[i][j][c] == 0) return -1;

                    res = Math.max(res, map[i][j][c]); //제일 작은수를 비교해서 무조건 map을 선택하게 한다.
                }
            }
        }
        if(res == 1) return 0;
        else return res - 1;
    }
}