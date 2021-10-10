import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, M, x, y, k;
    static int[][] map;
    static int[] dice = new int[7];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {

            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir - 1];
            int ny = y + dy[dir - 1];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                chDice(dir);

                if(map[nx][ny] == 0) {
                    map[nx][ny] = dice[6];
                } else {
                    dice[6]  = map[nx][ny];
                    map[nx][ny] = 0;
                }
                x = nx;
                y = ny;
                System.out.println(dice[1]);
            }
        }
    }
    public static void chDice(int dir) {
        int[] tmp = dice.clone();
        // 동서남북
        if(dir == 1) { //동쪽
            dice[1] = tmp[4];
            dice[3] = tmp[1];
            dice[4] = tmp[6];
            dice[6] = tmp[3];
        } else if(dir == 2) {
            dice[1] = tmp[3];
            dice[3] = tmp[6];
            dice[4] = tmp[1];
            dice[6] = tmp[4];
        } else if(dir == 3) {
            dice[1] = tmp[5];
            dice[2] = tmp[1];
            dice[5] = tmp[6];
            dice[6] = tmp[2];
        } else if(dir == 4) {
            dice[1] = tmp[2];
            dice[2] = tmp[6];
            dice[5] = tmp[1];
            dice[6] = tmp[5];
        }
    }
}