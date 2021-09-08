import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 11729 하노이의 탑 이동순서
 N: 원판의 개수, start, mid, to
 */
public class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, n) - 1)).append('\n');

        hanoi(n,1, 2, 3);
        System.out.println(sb);
    }
    public static void hanoi(int n, int start, int mid, int to) {
        if(n == 1) { //원판의 개수가 하나면 1 -> 3
            sb.append(start + " " + to + "\n");
            return;
        }
        /*
         1. n-1개의 원판을 A에서 B로 이동
         2. 남아있는 가장큰 원판을 A에서 c로 이동
         3. n-1개의 원판을 다시 B에서 C로 이동
         */
        hanoi(n - 1, start, to, mid); //1
        sb.append(start + " " + to + "\n"); //2
        hanoi(n - 1, mid, start, to); //3
    }
}