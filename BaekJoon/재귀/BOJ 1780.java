import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1780
 Date: 21-09-13
 */
public class Main {
    static int N;
    static int[][] map;
    static int white = 0;
    static int black = 0;
    static int blue = 0;
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

        System.out.println(white);
        System.out.println(black);
        System.out.println(blue);
    }
    public static void divide(int row, int col, int size) {

        if(check(row, col, size)) {
            if(map[row][col] == -1) {
                white++;
            }
            else if(map[row][col] == 0) {
                black++;
            }
            else {
                blue++;
            }
            return;
        }
        int newSize = size / 3;
        divide(row, col, newSize);
        divide(row, col + newSize, newSize);
        divide(row, col + 2 * newSize, newSize);

        divide(row + newSize, col, newSize);
        divide(row + newSize, col + newSize, newSize);
        divide(row + newSize, col + 2 * newSize, newSize);

        divide(row + 2 * newSize, col, newSize);
        divide(row + 2 * newSize, col + newSize, newSize);
        divide(row + 2 * newSize, col + 2 * newSize, newSize);
    }
    public static boolean check(int row, int col, int size) {
        int val = map[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(val != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
