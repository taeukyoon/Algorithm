import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 2447 별 찍기 -10
 Date: 21-09-10
 */
public class Main{
    static char[][] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = ' ';
            }
        }
        star(0, 0, N);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void star(int x, int y, int n) {

        //더이상 쪼갤수 없는 블럭
        if(n == 1) {
            arr[x][y] = '*';
            return;
        }
        n /= 3;

        for(int i = 0; i < 3; i++) { // 3*3크기의 크기의 별
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) {
                    continue;
                }
                star(x + (i * n), y + (j * n), n);  //시작점을 옮겨준다
            }
        }
    }
}