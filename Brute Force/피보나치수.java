import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BaekJoon-2747 피보나치수
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //범위 n입력
        int n = Integer.parseInt(br.readLine());
        System.out.println(Fibonacci(n-1));
    }
    //재귀사용
    private static int Fibonacci(int n) {
        if(n <= 1) {
            return 1;
        }else {
            return Fibonacci(n-1) + Fibonacci(n -2);
        }
    }
}