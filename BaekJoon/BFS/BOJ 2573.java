import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 2573 빙산
 출력: 빙산 분리되는 최초의 시간을 출력 분리가 되지않을시 0출력
 1. 빙산이 한 덩어리면 빙하를 녹인다.
 2. 두 덩어리 이상이면 반복횟수를 출력한다.
 */

class Pair {
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x, y;
}
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;
        int cnt = 0;

        while ((cnt = Separate()) < 2) {
            if (cnt == 0) {
                res = 0;
                break;
            }
            Melt();
            res++;
        }
        System.out.println(res);
    }
    public static int Separate() { // 빙산이 몇덩이인지
        visited = new boolean[N][M]; //분리요소 구분
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0 && !visited[i][j]) { //빙하의 높이가 존재하거나 방문하지 않은곳
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true; //방문

        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }
    /*
     빙하를 녹이는 함수
     1. 빙하가 녹아서 0이 되는걸 바다로 인식하여 필요이상으로 많이 녹인다.
     2. visted를 이용하여 많이 녹이는걸 방지한다.
     */
    public static void Melt() {
        Queue<Pair> qu = new LinkedList<>();

        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0) {
                    qu.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while(!qu.isEmpty()) {
            Pair p = qu.poll();
            int seaCnt = 0;

            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 0 && !visited[nx][ny]) {
                    seaCnt++;
                }
            }

            if(map[p.x][p.y] - seaCnt < 0) {
                map[p.x][p.y] = 0;
            }else {
                map[p.x][p.y] -= seaCnt;
            }
        }
    }
}