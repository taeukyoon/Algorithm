import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 20058 마법사 상어와 파이어스톰
 feedBack :rotate 부분 다시 한번더 복습
 */
public class Main{
    static int N, Q, size, res;
    static int[][] ice;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N); //맵
        ice = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int l = Integer.parseInt(st.nextToken());
            rotate(l);
            melt();
        }

        int max = 0;
        boolean[][] visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (ice[i][j] > 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    max = Math.max(max, size(i, j, visited));
                }
            }
        }

        System.out.println(res + "\n" + max);
    }

    public static int size(int x, int y, boolean[][] visited) {
        int cnt = 1;
        res += ice[x][y];

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (check(nx,ny) && ice[nx][ny] > 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                cnt += size(nx, ny, visited);
            }
        }
        return cnt;
    }

    public static void rotate(int l) {
        int[][] tmp = new int[size][size];
        int loop = size / (int) Math.pow(2, l);

        int x = 0;

        for (int i = 0; i < loop; i++) {
            int y = 0;
            if (i != 0) {
                x += (int) Math.pow(2, l);
            }
            for (int j = 0; j < loop; j++) {
                if (j != 0) {
                    y += (int) Math.pow(2, l);
                }

                for (int a = 0; a < (int) Math.pow(2, l); a++) {
                    for (int b = 0; b < (int) Math.pow(2, l); b++) {
                        tmp[x+b][y-a+(int) Math.pow(2, l) - 1] = ice[x+a][y+b];
                    }
                }
            }
        }
        ice = tmp;
    }

    public static void melt() {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (check(nx, ny)) {
                        if (ice[nx][ny] > 0) {
                            cnt++;
                        }
                    }
                }
                if (cnt < 3) {
                    qx.add(i);
                    qy.add(j);
                }
            }
        }

        while (!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            ice[x][y]--;
        }
    }
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }
}