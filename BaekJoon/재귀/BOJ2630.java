import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 2630 색종이 만들기
 */
public class Main {
    static int N;
    static int[][] map;
    static int[] cnt = new int[2];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        for(int res : cnt) {
            System.out.println(res);
        }
    }
    public static void divide(int row, int col, int size) {
        int newSize = size / 2;

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(map[i][j] != map[row][col]) {
                    divide(row, col, newSize);
                    divide(row, col + newSize, newSize);
                    divide(row + newSize, col, newSize);
                    divide(row + newSize, col + newSize, newSize);
                    return;
                }
            }
        }
        cnt[map[row][col]]++;
    }
}