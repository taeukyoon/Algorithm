import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 BOJ 10773 제로
 스택을 이용하거나 배열을 이용한다.
 */
class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                stack.pop();
            }else {
                stack.add(input);
            }
        }
        int sum = 0;
        for(int value : stack) {
            sum += value;
        }
        System.out.println(sum);
    }
}