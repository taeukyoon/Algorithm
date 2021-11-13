import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 17142
 Date: 21-11-13
 solve: 조합, bfs
 */
public class Main {
    static int N, M;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static ArrayList<Virus> list = new ArrayList<>();
    static Virus[] active;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int emptySpace = 0;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        active = new Virus[M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 0) {
                    emptySpace++;
                } else if(map[i][j] == 2) {
                    list.add(new Virus(i, j, 0));
                }
            }
        }

        if(emptySpace == 0) {
            System.out.println(0);
        } else {
            combination(0, 0);
            System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        }
    }


    public static void combination(int start, int cnt) {
        if(cnt == M) {
            bfs(emptySpace);
            return;
        }
        else {
            for(int i = start; i < list.size(); i++) {
                active[cnt] = list.get(i);
                combination(i + 1, cnt + 1);
            }
        }
    }

    public static void bfs(int emptySpace) {
        Queue<Virus> qu = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < M; i++) {
            Virus v = active[i];
            visited[v.x][v.y] = true;
            qu.add(v);
        }

        while (!qu.isEmpty()) {
            Virus cur = qu.poll();

            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny] || map[nx][ny] == 1) continue;

                if(map[nx][ny] == 0) {
                    emptySpace--;
                }

                if(emptySpace == 0) {
                    result = Math.min(result, cur.time + 1);
                    return;
                }

                visited[nx][ny] = true;
                qu.add(new Virus(nx, ny, cur.time + 1));
            }
        }
    }
}
class Virus {
    int x, y, time;

    public Virus(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
