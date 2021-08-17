import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 2206 벽 부수고 이동하기
 1. 최단경로 구하기 (bfs)
 2. 벽을 한번 부술수 있다. -> visited를 이용하여 부순횟수와 방문체크를 동시에
 */
class Main{
    static int n, m, res;
    static int[][] map, visited;
    static Queue<Place> qu;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0 ,1};

    static class Place {
        public Place(int x, int y, int d, int broken) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.broken = broken;
        }

        int x, y, d;
        int broken;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        res = bfs(0, 0);
        System.out.println(res);
    }
    static int bfs(int x, int y) {
        qu = new LinkedList<>();
        qu.add(new Place(x, y, 1, 0)); //처음 좌표
        visited[y][x] = 0; // 공사 0회

        while(!qu.isEmpty()) {
            Place p = qu.poll();

            if(p.x == m - 1 && p.y == n - 1) { //도착지점 만나면 종료
                return p.d;
            }

            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if(visited[ny][nx] > p.broken) {
                        if(map[ny][nx] == 0) { //벽이 아닌곳
                            qu.add(new Place(nx, ny, p.d + 1, p.broken));
                            visited[ny][nx] = p.broken;
                        }
                        else {
                            if(p.broken == 0) {
                                qu.add(new Place(nx, ny, p.d + 1, p.broken + 1));
                                visited[ny][nx] = p.broken + 1;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
