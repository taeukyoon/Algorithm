import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 BOJ 7562 나이트의 이동
 1. 나이트의 이동방향은 8방향이다.
 2. 나이트의 이동거리의 최소거리를 구하는 거기 떄문에 bfs를 사용한다.
 */

class Main{
    static int t, n;
    static int sx, sy, ex, ey;
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pair> qu;

    static class Pair {
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            bfs(sx,sy);
            System.out.println(map[ex][ey]);
        }
    }
    static void bfs(int x, int y) {
        qu = new LinkedList<>();
        qu.add(new Pair(x, y));
        visited[x][y] = true;

        while(!qu.isEmpty()) {
            Pair p = qu.poll();

            if(p.x == ex && p.y == ey) break;

            for(int k = 0; k < 8; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(!visited[nx][ny]) {
                        qu.add(new Pair(nx,ny));
                        visited[nx][ny] = true;
                        map[nx][ny] = map[p.x][p.y] + 1;
                    }
                }
            }
        }
    }
}