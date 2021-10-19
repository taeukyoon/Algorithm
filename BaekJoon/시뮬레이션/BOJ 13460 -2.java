import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 13460
 */
public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static Node red, blue;
    static int holeX, holeY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'R') {
                    red = new Node(i, j, 0, 0, 0);
                } else if (map[i][j] == 'B') {
                    blue = new Node(0, 0, i, j, 0);
                } else if(map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }
        System.out.println(bfs());
        br.close();
    }
    public static int bfs() {
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(red.Rx, red.Ry, blue.Bx, blue.By, 1));
        visited[red.Rx][red.Ry][blue.Bx][blue.By] = true;

        while(!qu.isEmpty()) {
            Node now = qu.poll();

            int curRx = now.Rx;
            int curRy = now.Ry;
            int curBx = now.Bx;
            int curBy = now.By;
            int curCnt = now.cnt;

            if(curCnt > 10) {
                return -1;
            }

            for(int k = 0; k < 4; k++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while(map[newRx+dx[k]][newRy+dy[k]] != '#') {
                    newRx += dx[k];
                    newRy += dy[k];

                    if(newRx == holeX && newRy == holeY) {
                        isRedHole = true;
                        break;
                    }
                }
                while(map[newBx+dx[k]][newBy+dy[k]] != '#') {
                    newBx += dx[k];
                    newBy += dy[k];

                    if(newBx == holeX && newBy == holeY) {
                        isBlueHole = true;
                        break;
                    }
                }
                if(isBlueHole) { //다른 좌표도 고
                    continue;
                }
                if(isRedHole && !isBlueHole) {
                    return curCnt;
                }
                //빨간공과 파란공이 같은 좌표로 갈시엔 --> 위치조정
                //상하좌우 방향에 따른 x,y 좌표값 비교
                if(newRx == newBx && newRy == newBy) {
                    if(k == 0) { //위
                        if(curRx > curBx) newRx -= dx[k]; //파란공이 이동거리가 더짧으므로 빨간색공을 옮겨준다
                        else newBx -= dx[k];
                    } else if(k == 1) { //우
                        if(curRy < curBy) newRy -= dy[k];
                        else newBy -= dy[k];
                    } else if(k == 2) { //아래
                        if(curRx < curBx) newRx -= dx[k];
                        else newBx -= dx[k];
                    } else { //왼
                        if(curRy > curBy) newRy -= dy[k];
                        else  newBy -= dy[k];
                    }
                }
                if(!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    qu.add(new Node(newRx, newRy, newBx, newBy, curCnt + 1));
                }
            }
        }
        return -1;
    }
}
class Node {
    public Node(int rx, int ry, int bx, int by, int cnt) {
        Rx = rx;
        Ry = ry;
        Bx = bx;
        By = by;
        this.cnt = cnt;
    }

    int Rx, Ry, Bx, By, cnt;
}