import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 14890
 Date: 21-10-25
 */
public class Main{
    static int N, L, cnt;
    static int[][] map;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            if(solve(i,0,0)) {
                cnt++;
            }
            if(solve(0,i,1)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static boolean solve(int x, int y, int dir) {
        int[] height = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            height[i] = (dir == 0) ? map[x][y+i] : map[x+i][y];
        }

        for(int i = 0; i < N-1; i++) {
            if(height[i] == height[i+1]) {
                continue;
            }

            if(Math.abs(height[i] - height[i+1]) > 1) {
                return false;
            }

            if(height[i] - 1 == height[i+1]) {
                for(int j = i+1; j <= i+L; j++) {
                    if(j >= N || height[i+1] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }

            else if(height[i] + 1 == height[i+1]) {
                for(int j = i; j > i-L; j--) {
                    if(j < 0 || height[i] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}