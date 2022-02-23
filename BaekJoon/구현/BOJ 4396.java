import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 4396 지뢰 찾기
 */
public class Main {
    static int n, m;
    static char[][] mineMap, infoMap;
    static boolean flag = false;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; //시계방향
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        mineMap = new char[n][n];
        infoMap = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                mineMap[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                infoMap[i][j] = input.charAt(j);
            }
        }
        game();
        boom();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(infoMap[i][j]);
            }
            System.out.println();
        }
    }
    public static void game() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                if (infoMap[i][j] == 'x') {
                    if (mineMap[i][j] == '*') {
                        flag = true;
                    }
                    else {
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (mineMap[nx][ny] == '*') cnt++;
                        }
                        infoMap[i][j] = (char) (cnt + '0'); // 0~9 int -> char
                    }
                }
                else { //x가 아닌곳
                    infoMap[i][j] = '.';
                }
            }
        }
    }
    public static void boom() {
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mineMap[i][j] == '*') {
                        infoMap[i][j] = '*';
                    }
                }
            }
        }
    }
}
