import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 17070 파이프 분리
 */
public class Main {
    static int N, cnt;
    static int[][] map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        //집상태
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dir 0: 가로, 1: 세로, 2: 대각선
        move(0, 1, 0); //시작점
        System.out.println(cnt);
    }

    public static void move(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1 && map[x][y] != 1) {
            cnt++;
            return;
        }

        //가로 방향
        if (dir == 0) {
            if (check(x, y+1) && map[x][y+1] == 0) { //가로로 밀때
                move(x, y+1, 0);
            }
            if (check(x+1, y+1) && map[x][y+1] == 0 && map[x+1][y+1] == 0 && map[x+1][y] == 0) {
                move(x+1,  y+1, 2);
            }
        }

        if (dir == 1) {
            if (check(x+1, y) && map[x+1][y] == 0) {
                move(x+1, y, 1);
            }
            if (check(x+1, y+1) && map[x][y+1] == 0 && map[x+1][y+1] == 0 && map[x+1][y] == 0) {
                move(x+1, y+1, 2);
            }
        }

        if (dir == 2) {
            if (check(x, y+1) && map[x][y+1] == 0) {
                move(x, y+1, 0);
            }
            if (check(x+1,  y) && map[x+1][y] == 0) {
                move(x+1, y, 1);
            }
            if (check(x+1, y+1) && map[x][y+1] == 0 && map[x+1][y+1] == 0 && map[x+1][y] == 0) {
                move(x+1, y+1, 2);
            }
        }
    }
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
