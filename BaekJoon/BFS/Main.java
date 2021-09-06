
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Pair>[][] switches;
    static boolean[][] visited; //방문체크
    static boolean[][] isLight; //불이 켜진방
    static boolean[][] isMove; //이동이 가능한 방
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Pair{

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        switches = new ArrayList[n][n];

        for(int i = 0; i < n; i++) { //크기
            for(int j = 0; j < n; j++) {
                switches[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            switches[x][y].add(new Pair(a, b));
        }

        System.out.println(bfs());
    }
    public static int bfs() {

        visited = new boolean[n][n];
        isLight = new boolean[n][n];
        isMove = new boolean[n][n];

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(0, 0));
        visited[0][0] = true; //시작지점
        isLight[0][0] = true;
        int cnt = 1;

        while(!qu.isEmpty()) {
            Pair p = qu.poll();

            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                isMove[nx][ny] = true;
            }

            for(Pair ps : switches[p.x][p.y]) {
                if(!isLight[ps.x][ps.y]) {
                    isLight[ps.x][ps.y] = true;
                    cnt++;

                    if(isMove[ps.x][ps.y] && !visited[ps.x][ps.y]) {
                        visited[ps.x][ps.y] = true;
                        qu.add(new Pair(ps.x, ps.y));
                    }
                }
            }
            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(visited[nx][ny] || !isLight[nx][ny] || !isMove[nx][ny]) continue;

                visited[nx][ny] = true;
                qu.add(new Pair(nx, ny));
            }
        }
        return cnt;
    }
}
