import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/*
 BOJ 15684
 Date: 21-10-26
 solve: 탐색, dfs
 */
public class Main{
    static int N, M, H, res;
    static int[][] map;
    static boolean flag = false;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[a][b+1] = -1;
        }
        for(int i = 0; i <= 3; i++) {
            res = i;
            dfs(1, 0);
            if(flag) break;
        }
        System.out.println((flag) ? res : -1);
    }
    public static void dfs(int x, int cnt) {
        if(flag) return; //실행되면 종료

        if(cnt == res) {
            if(check()) flag = true;
            return;
        }

        for(int i = x; i < H + 1; i++) { //전체범위
            for(int j = 1; j < N; j++) {
                if(map[i][j] == 0 && map[i][j+1] == 0) {
                    map[i][j] = 1;
                    map[i][j+1] = -1;
                    dfs(i, cnt + 1);
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
    }
    public static boolean check() { //i가 i번째로 나오게
        for(int i = 1; i < N; i++) {
            int x = 1 , y = i;
            for(int j = 0; j < H; j++) {
                if(map[x][y] == 1) y++;
                else if(map[x][y] == -1) y--;
                x++;
            }
            if(y != i) return false;
        }
        return true;
    }
}