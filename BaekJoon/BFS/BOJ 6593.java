
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 6593
 */
public class Main{
    static char[][][] map;
    static boolean[][][] visited;
    static int l, r, c;
    static int visitCnt;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Node> qu;
    static class Node {
        int h, x, y, cnt;

        public Node(int h, int x, int y, int cnt) {
            this.h = h;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new char[l][r][c];
            visited = new boolean[l][r][c];
            if(l == 0 && r == 0 && c == 0) {
                break;
            }
            qu = new LinkedList();
            visitCnt = 0;
            for(int i = 0; i < l; i++) {
                for(int j = 0; j < r; j++) {
                    String input = br.readLine();
                    for(int k = 0; k < c; k++) {
                        map[i][j][k] = input.charAt(k);
                        if(map[i][j][k] == 'S') {
                            Node n = new Node(i, j, k, 0);
                            qu.add(n);
                        }
                    }
                }
                br.readLine();
            }
            bfs();
            if(visitCnt == 0) {
                System.out.println("Trapped!");
            }
        }
    }
    public static void bfs() {
        while(!qu.isEmpty()) {
            Node p = qu.poll();
            for(int k = 0; k < 6; k++) {
                int nh = p.h + dz[k];
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nh < 0 || nx < 0 || ny < 0 || nh >= l || nx >= r || ny >= c) continue;
                if(map[nh][nx][ny] == '.' && !visited[nh][nx][ny]) {
                    qu.add(new Node(nh, nx, ny, p.cnt + 1));
                    visited[nh][nx][ny] = true;
                } else if(map[nh][nx][ny] == 'E') {
                    visitCnt++;
                    p.cnt++;
                    System.out.println("Escaped in "+p.cnt+" minute(s). ");
                    qu.clear();
                    break;
                }
            }
        }
    }
}