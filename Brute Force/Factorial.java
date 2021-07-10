
/*
    백준 10872 팩토리얼
    Recursion 사용해서 풀기
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //입력ㄱ밧
        sc.close();

        System.out.println(factorial(N));
    }
    private static int factorial(int N) {
        if(N == 1) {
            return 1;
        } else {
            return factorial(N - 1) * N; //재귀
        }
    }
}
