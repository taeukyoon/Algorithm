import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, M, T;
    static int[][] arr;
    static boolean[][] visited;
    static boolean flag;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //몇배수
            int d = Integer.parseInt(st.nextToken()); //방향 0시계 1 반시계
            int k = Integer.parseInt(st.nextToken()); //횟수

            rotate(x, d, k);

        }
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != -1) {
                    res += arr[i][j];
                }
            }
        }
        System.out.println(res);
    }
    public static void rotate(int x, int d, int k) {
        int tmpX = x;
        visited = new boolean[N][M];

        while (tmpX - 1 < N) {
            if(d == 0) { //시계방향
                for(int i = 0; i < k; i++) { //횟수
                    int temp = arr[tmpX - 1][M - 1];

                    for(int j =  M - 1; j >= 1; j--) {
                        arr[tmpX - 1][j] = arr[tmpX - 1][j - 1];
                    }
                    arr[tmpX - 1][0] = temp;
                }
            } else if(d == 1) {
                for(int i = 0; i < k; i++) { //앞이 뒤로
                    int temp = arr[tmpX - 1][0];

                    for(int j = 0; j < M -1; j++) {
                        arr[tmpX - 1][j] = arr[tmpX - 1][j + 1];
                    }
                    arr[tmpX - 1][M - 1] = temp;
                }
            }
            tmpX += x;
        }
        flag = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != -1 && !visited[i][j]) {
                    check(i, j, arr[i][j]);
                }
            }
        }
        if(!flag) {
            solve();
        }
    }
    public static void solve() {
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != -1) {
                    sum += arr[i][j];
                    cnt++;
                }
            }
        }
        float avg = (float) (sum) / cnt;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != -1) {
                    if(arr[i][j] < avg) {
                        arr[i][j] += 1;
                    } else if(arr[i][j] > avg) {
                        arr[i][j] -= 1;
                    }
                }
            }
        }
    }

    public static void check(int x, int y, int val) { //인접하면서 같은 수 찾기
        visited[x][y] = true;
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(ny < 0) {
                ny = M - 1;
            } else if (ny >= M) {
                ny = 0;
            }

            if(0 <= nx && nx < N) {
                if(!visited[nx][ny] && arr[nx][ny] == val) {
                    flag = true;
                    arr[x][y] = -1;
                    arr[nx][ny] = -1;
                    check(nx, ny, val);
                }
            }
        }
    }
}