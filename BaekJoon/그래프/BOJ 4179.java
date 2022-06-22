import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 BOJ 4179 불
 */
class Main{
    static int r,c,d;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Pair> fire, jh;

    static class Pair{
        int x, y, c;
        public Pair(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        jh = new LinkedList<>();
        fire = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 'J') {
                    jh.add(new Pair(i, j, 0));
                }
                else if(map[i][j] == 'F') {
                    fire.add(new Pair(i, j , 0));
                }
            }
        }
        if(bfs()) System.out.println(d);
        else System.out.println("IMPOSSIBLE");
    }
    public static boolean bfs() {
        while(!jh.isEmpty()) {
            int size = fire.size();
            for(int i = 0; i < size; i++) {
                Pair now = fire.poll();

                for(int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dx[k];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if(map[nx][ny] == 'F' || map[nx][ny] == '#') continue;
                    map[nx][ny] = 'F';
                    fire.add(new Pair(nx, ny, now.c + 1));
                }
            }

            size = jh.size();
            for(int i = 0; i < size; i++) {
                Pair now = jh.poll();
                for(int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        d = now.c + 1;
                        return true;
                    }

                    if(map[nx][ny] == '#' || map[nx][ny] == 'F' || map[nx][ny] == 'J') continue;
                    map[nx][ny] = 'J';
                    jh.add(new Pair(nx, ny, now.c + 1));
                }
            }
        }
        return false;
    }

}