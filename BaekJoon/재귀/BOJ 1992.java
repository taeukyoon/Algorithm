import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 1992 쿼드트리
 Date: 21-09-13
 */
public class Main{
    static int N, M;
    static int[][] map;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        divide(0,0,N);
    }
    public static void divide(int row, int col, int size) {
        if(check(row, col, size)) {
            System.out.print(M);
        }
        else {
            System.out.print('(');
            int newSize = size / 2;
            divide(row, col, newSize);
            divide(row, col + newSize, newSize);
            divide(row + newSize, col, newSize);
            divide(row + newSize, col + newSize, newSize);
            System.out.print(')');
        }
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
        M = val;
        return true;
    }
}