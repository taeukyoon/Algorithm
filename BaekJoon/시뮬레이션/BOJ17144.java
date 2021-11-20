import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int R, C, T;
    static int[][] arr;
    static Queue<Dust> dust;
    static int cleaner = -1;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == -1 && cleaner == -1) {
                    cleaner = i;
                }
            }
        }
        process();

        int res = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == -1) continue;
                res += arr[i][j];
            }
        }
        System.out.println(res);
    }

    public static void process() {
        for(int i = 0; i < T; i++) {
            checkDust(); //먼지 공간확인

            spreadDust(); //먼지 확산

            operate(); //공기청정기 가동
        }
    }

    public static void checkDust() {
        dust = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == -1 || arr[i][j] == 0) continue;
                //미세먼지 위치와 양
                dust.add(new Dust(i, j, arr[i][j]));
            }
        }
    }

    public static void spreadDust() {
        while (!dust.isEmpty()) {
            Dust now = dust.poll();
            if(now.w < 5) continue; //5이하면 0이 더해져서 필요없다.

            int sumDust = now.w / 5;
            int cnt = 0;
            for(int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue; //범위 초과
                if(arr[nx][ny] == -1) continue; //공기청정기 있는곳은 먼지확산 x

                arr[nx][ny] += sumDust;
                cnt++;
            }
            arr[now.x][now.y] -= sumDust * cnt;
        }
    }

    public static void operate() {
        int top = cleaner;
        int down = cleaner + 1; //위아래

        //바람 순환 (아래, 왼쪽, 위, 오른쪽) 반시계
        for(int i = top - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }
        for(int i = 0; i < C -1; i++) {
            arr[0][i] = arr[0][i + 1];
        }
        for(int i = 0; i < top; i++) {
            arr[i][C-1] = arr[i + 1][C-1];
        }
        for(int i = C - 1; i > 1; i--) {
            arr[top][i] = arr[top][i - 1];
        }
        arr[top][1] = 0;

        // 시계방향(위, 왼, 아래, 오른쪽)
        for(int i = down + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }
        for(int i = 0; i < C - 1; i++) {
            arr[R-1][i] = arr[R-1][i+1];
        }
        for(int i = R - 1; i > down; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }
        for(int i = C - 1; i > 1; i--) {
            arr[down][i] = arr[down][i - 1];
        }
        arr[down][1] = 0;
    }
}

class Dust {
    int x, y, w;

    public Dust(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
}