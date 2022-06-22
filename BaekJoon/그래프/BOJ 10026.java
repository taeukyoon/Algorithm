import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 BOJ 10026 적록색약
 1.BFS, DFS 모두다 사용가능하다. (bfs사용했음)
 2.적록색약이 아닌경우에서 bfs, 'R'과 'G'을 똑같이 만든후 bfs한번씩 수행하면 된다.
 */
class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static Queue<Pair> qu;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pair {
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j];
            }
        }
        int count1 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(new Pair(i, j));
                    count1++;
                }
            }
        }
        visited = new boolean[n][n]; //방문초기화

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
        int count2 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(new Pair(i , j));
                    count2++;
                }
            }
        }
        System.out.println(count1+ " " + count2);
    }
    static void bfs(Pair p) {
        qu = new LinkedList<>();
        int color = map[p.x][p.y];
        visited[p.x][p.y] = true;
        qu.add(p);

        while(!qu.isEmpty()) {
            Pair bp = qu.poll();
            for(int k = 0; k < 4; k++) {
                int nx = bp.x + dx[k];
                int ny = bp.y + dy[k];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(map[nx][ny] == color && !visited[nx][ny]) {
                        qu.add(new Pair(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}