import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 5427 불
 1. 불과 상근이의 시작위치를 준다음 bfs로 각자 순회한다
 2. 불을 먼저 이동시킨후 상근이를 이동시킨다.
 */

class Pair{

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }

    int x, y, t;
}
public class Main {
    static int w, h, result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static Queue<Pair> sg, fire;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        for(int i = 1; i <= test; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            sg = new LinkedList<>();
            fire = new LinkedList<>();

            for(int a = 0; a < h; a++) {
                char[] ch = br.readLine().toCharArray();
                for(int b = 0; b < w; b++) {
                    map[a][b] = ch[b];
                    if(map[a][b] == '*') fire.add(new Pair(a, b));
                    else if(map[a][b] == '@') sg.add(new Pair(a, b, 0));
                }
            }
            result = 0;
            bfs();
            if(result == 0) System.out.println("IMPOSSIBLE");
            else System.out.println(result);
        }
    }
    public static void bfs() {

        int size = 0;
        while(!sg.isEmpty()) {
            size = fire.size();
            for(int k = 0; k < size; k++) {
                Pair fired = fire.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = fired.x + dx[j];
                    int ny = fired.y + dy[j];

                    if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if(map[nx][ny] == '.' || map[nx][ny] == '@') {
                        map[nx][ny] = '*';
                        fire.add(new Pair(nx, ny));
                    }
                }
            }
            size = sg.size();
            for(int a = 0; a < size; a++) {
                Pair p = sg.poll();
                for(int c = 0; c < 4; c++) {
                    int nx = p.x + dx[c];
                    int ny = p.y + dy[c];

                    if(nx < 0 || ny < 0 || nx >= h || ny >= w) { // 탈출한다면
                        result = p.t + 1;
                        return;
                    }
                    if(map[nx][ny] == '.') {
                        map[nx][ny] = '@';
                        sg.add(new Pair(nx, ny, p.t + 1));
                    }
                }
            }
        }
    }
}