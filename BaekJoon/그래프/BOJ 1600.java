import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 BOJ 1600 말이 되고픈 원숭이

 */
public class Main{
    static int k, w, h;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] hx = {1,2,2,1,-1,-2,-2,-1};
    static int[] hy = {-2,-1,1,2,2,1,-1,-2};

    static class Pair{
        public Pair(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }

        int x, y, k, cnt;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][31]; //말의 행동을 할수있는 상태의 대한 체크
        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0][0] = true;
        bfs();
    }
    public static void bfs() {
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(0,0, k ,0));


        while(!qu.isEmpty()) {
            Pair cur = qu.poll();

            if(cur.x == w - 1 && cur.y == h- 1) { //젤 끝에 도달하면 종료
                System.out.println(cur.cnt);
                return;
            }
            if(cur.x < 0 || cur.y < 0 || cur.x >= w || cur.y >= h) continue;

            if(map[cur.y][cur.x] == 1) continue;

            if(visited[cur.y][cur.x][cur.k]) continue;

            visited[cur.y][cur.x][cur.k] = true;

            for(int j = 0; j < 4; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];

                qu.add(new Pair(nx, ny, cur.k, cur.cnt + 1));
            }

            if(cur.k == 0) continue; //말움직임 할 수 있는 횟수확인
            for(int j = 0; j < 8; j++) {
                int nx = cur.x + hx[j];
                int ny = cur.y + hy[j];

                qu.add(new Pair(nx, ny, cur.k - 1, cur.cnt + 1));
            }
        }
        System.out.println(-1);
    }
}