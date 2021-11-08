import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 16236 아기상어
 Date: 21-11-08
 */
public class Main {
    static int N, sharkX, sharkY, eatCnt, answer;
    static int sharkSize = 2;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    map[i][j] = 0;
                }
            }
        }
        Queue<Shark> q = new PriorityQueue<>((o1, o2) -> {
            if(o1.dist == o2.dist) {
                if(o1.y == o2.y) return Integer.compare(o1.x, o2.x);
                return Integer.compare(o1.y, o2.y);
            }
            return Integer.compare(o1.dist, o2.dist);
        });

        q.add(new Shark(sharkY, sharkX, 0));
        visited = new boolean[N][N];
        visited[sharkY][sharkX] = true;

        while (!q.isEmpty()) {
            Shark cur = q.poll();

            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;

                if(map[ny][nx] <= sharkSize) {
                    q.add(new Shark(ny, nx, cur.dist + 1));
                }
            }
            if(q.peek() != null) {
                Shark peek = q.peek();
                if(map[peek.y][peek.x] < sharkSize && map[peek.y][peek.x] > 0) {
                    eatCnt++;
                    if(eatCnt == sharkSize) {
                        sharkSize++;
                        eatCnt = 0;
                    }
                    map[peek.y][peek.x] = 0;

                    q.clear();
                    q.add(new Shark(peek.y, peek.x, 0));
                    answer += peek.dist;
                    visited = new boolean[N][N];
                    visited[peek.y][peek.x] = true;
                }
            }
        }
        System.out.println(answer);
    }
}
class Shark{
    public Shark(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }

    int y, x, dist;
}