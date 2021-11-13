import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 17141
 Date: 21-11-12
 */
public class Main {
    static int N, M, val;
    static int res = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Virus> list = new ArrayList<>();


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    list.add(new Virus(i, j));
                    map[i][j] = 0;
                }
            }
        }
        visited = new boolean[list.size()];
        combination(0, 0);

        if(res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res -1);
        }
    }
    public static void combination(int start, int cnt) {
        if(cnt >= M) {
            bfs();
            res = Math.min(res, val);
            return;

        } else {
            for(int i = start; i < list.size(); i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    combination(i + 1, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void bfs() {
        Queue<Virus> qu = new LinkedList<>();

        int[][] tmp = new int[N][N]; //맵 복사
        int[][] time = new int[N][N];

        for(int i = 0; i < N; i++) {
            tmp[i] = map[i].clone();
        }

        for(int i = 0; i < list.size(); i++) { //구한 위치에 바이러스 주입
            if(visited[i]) {
                map[list.get(i).x][list.get(i).y] = 0;
                time[list.get(i).x][list.get(i).y] = 1;
                qu.add(list.get(i));
            }
        }

        val = 0;

        while (!qu.isEmpty()) {

            Virus cur = qu.poll();
            int qx = cur.x;
            int qy = cur.y;
            int qt = time[qx][qy];

            val = Math.max(val, qt);

            for(int k = 0; k < 4; k++) {
                int nx = qx + dx[k];
                int ny = qy + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || tmp[nx][ny] != 0 || time[nx][ny] != 0) continue; //범위 초과
                if(tmp[nx][ny] == 0 && time[nx][ny] == 0) {
                    time[nx][ny] = qt + 1;
                    tmp[nx][ny] = 2;
                    qu.add(new Virus(nx, ny));
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(tmp[i][j] == 0 && time[i][j] == 0) {
                    val = Integer.MAX_VALUE;
                    return;
                }
            }
        }
    }
}
class Virus {
    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x, y;
}