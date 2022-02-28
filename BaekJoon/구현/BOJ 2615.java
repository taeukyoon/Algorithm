import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 2615 오목
 */
public class Main {
    static int[][] checkBoard = new int[21][21];
    static int[][][] tmp = new int[21][21][4];
    static int[] dx = {1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = 19;
        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= size; j++) {
                checkBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(search());
    }
    public static String search() {
        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (checkBoard[i][j] != 0) {

                    for (int d = 0; d < 4; d++) {
                        if (tmp[i][j][d] == 0 && (cal(i, j, d, checkBoard[i][j]) == 5)) {
                            return checkBoard[i][j] + "\n" + i + " " + j;
                        }
                    }
                }
            }
        }
        return "0";
    }

    public static int cal(int x, int y, int dir, int color) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (checkBoard[nx][ny] == color) {
            return tmp[nx][ny][dir] = cal(nx, ny, dir, color) + 1;
        }
        return 1;
    }
}
