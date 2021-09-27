import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 9663 N-Queen
 Date: 21-09-27
 */
public class Main{
    static int N;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Nqueen(0);
        System.out.println(cnt);
    }
    public static void Nqueen(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }
        for(int i = 0; i < N; i++) {
            arr[depth] = i;

            if(Possible(depth)) { //같은 행이나 대각선에 있는것은 불가능
                Nqueen(depth + 1);
            }
        }
    }
    public static boolean Possible(int col) {
        for(int i = 0; i < col; i++) {
            //다음 열이 같은행이면 불가능
            if(arr[col] == arr[i]) {
                return false;
            }
            //대각선에 위치하는것
            //열의 차와 행의 차가 같으면 대각선에 존재한다.
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}