import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 2448 별찍기 - 11
 Date: 21-09-11
 */
public class Main {
    static char[][] map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int row = N;
        int col = (2 * N) - 1;
        int center = N - 1;

        map = new char[row][col];
        // 초기화
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = ' ';
            }
        }
        drawStar(0, center, N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void drawStar(int row, int col, int size) {
        //base
        if(size == 3) {
            map[row][col] = '*';
            map[row+1][col+1] = map[row+1][col-1] = '*';
            map[row+2][col-2] = map[row+2][col-1] = map[row+2][col] = map[row+2][col+2] = map[row+2][col+1] = '*';
            return;
        } else {
            int cut = size / 2;
            drawStar(row, col, cut);
            drawStar(row + cut, col + cut, cut);
            drawStar(row + cut, col - cut, cut);
        }

    }
}
