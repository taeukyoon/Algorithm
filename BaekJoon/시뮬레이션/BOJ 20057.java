import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dc = {1, 1, 2, 2};

    //모래확산
    static int[][] dsx = {{-1, 1, -2, -1, 1, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2},
                            {1, -1, 2, 1, -1, -2, 1, -1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
    static int[][] dsy = {{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -2, -1, 1, 2, -1, 1, 0},
                            {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 2, 1, -1, -2, 1, -1, 0}};
    static int[] sandRatio = {1, 1, 2, 7, 7, 2, 10, 10, 5};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int amount = tornado(N/2, N/2);
        System.out.println(amount);
    }

    //토네이도 이동 1122, 3344
    public static int tornado(int x, int y) {
        int res = 0;
        int curX = x;
        int curY = y;

        while (true) {
            for (int k = 0; k < 4; k++) {
                for (int moveCount = 0; moveCount < dc[k]; moveCount++) {
                    int nx = curX + dx[k];
                    int ny = curY + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        return res;
                    }

                    //모래 뿌리기
                    int sand = map[nx][ny];
                    map[nx][ny] = 0;
                    int totalSand = 0;

                    for (int i = 0; i < 9; i++) { //모래흩날
                        int sandX = nx + dsx[k][i];
                        int sandY = ny + dsy[k][i];

                        int amount = (sand*sandRatio[i])/100;

                        if (sandX < 0 || sandY < 0 || sandX >=N || sandY >= N) {
                            res += amount;
                        }
                        else {
                            map[sandX][sandY] += amount;
                        }
                        totalSand += amount;
                    }

                    //알파
                    int aX = nx + dx[k];
                    int aY = ny + dy[k];
                    int aAmount = sand - totalSand;

                    if (aX < 0 || aY < 0 || aX >= N || aY >= N) {
                        res += aAmount;
                    }
                    else {
                        map[aX][aY] += aAmount;
                    }

                    curX = nx;
                    curY = ny;
                }
            }

            for (int i = 0; i < 4; i++) {
                dc[i] += 2;
            }
        }
    }
}
