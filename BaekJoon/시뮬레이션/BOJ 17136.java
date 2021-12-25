import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 17136 색종이 붙이기
 DFS, 백트래킹
 */
public class Main{
    static int[][] map;
    static final int size = 10;
    static int[] remain = {0, 5, 5, 5, 5, 5}; //각 색종이의 남은 개수
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0); //맵의(0,0)에서 오른쪽 아래로 진행

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void dfs(int r, int c, int cnt) {
        if (r >= 9 && c > 9) { //종이의 끝에 도달
            res = Math.min(res, cnt);
            return;
        }

        if (cnt >= res) {
            return;
        }

        if (c > 9) { //좌표가 넘기때문에 아래쪽으로 이동
            dfs(r+1, 0, cnt);
            return;
        }

        if (map[r][c] == 1) {
            for (int i = 5; i > 0; i--) { //큰 색종이부터 붙인다
                if (remain[i] > 0 && check(r, c, i)) {
                    attach(r, c, i, 0);
                    remain[i]--;
                    dfs(r, c + 1, cnt + 1);
                    attach(r, c, i, 1);
                    remain[i]++;
                }
            }
        } else { //그냥 이동
            dfs(r, c+1, cnt);
        }
    }

    public static void attach(int r, int c, int size, int state) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = state; //색종이 붙임 0상태 붙이기 1
            }
        }
    }

    public static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (i < 0 || j < 0 || i > 9 || j > 9) return false;

                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }
}