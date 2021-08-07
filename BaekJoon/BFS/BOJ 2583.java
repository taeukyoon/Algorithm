import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 BOJ 2583 영역구하기
 BFS, DFS 둘다가능
 */
class Main{
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int m, n, k, count;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> list;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    map[y][x] =1;
                }
            }
        }
        list = new ArrayList<Integer>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            if(list.size() != 0) System.out.print(list.get(i) + " ");
            else System.out.println(0);
        }

    }
    static void bfs(int x, int y) {
        qu = new LinkedList<>();
        qu.add(new Pair(x,y));
        visited[x][y] = true;
        int cnt = 0;
        while (!qu.isEmpty()) {
            cnt++;
            Pair p = qu.poll();
            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if(!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        qu.add(new Pair(nx,ny));
                    }
                }
            }
        }
        list.add(cnt);
    }
}