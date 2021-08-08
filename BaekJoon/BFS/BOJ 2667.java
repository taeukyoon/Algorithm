import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pair> qu;
    static ArrayList<Integer> list;

    static class Pair {
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }
    /*
     BOJ 2667 단지번호
     BFS, DFS 둘 다 사용가능
     */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        int count = 0;
        list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            if(list.size() != 0) System.out.println(list.get(i) + " ");
            else System.out.println(0);
        }
    }
    static void bfs(int x, int y) {
        qu = new LinkedList<>();
        qu.add(new Pair(x,y));
        visited[x][y] = true;
        int cnt = 0;
        while(!qu.isEmpty()) {
            cnt++;
            Pair p = qu.poll();
            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] =  true;
                        qu.add(new Pair(nx, ny));
                    }
                }
            }
        }
        list.add(cnt);
    }
}