import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 BOJ 1847 스택수열
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader be = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(be.readLine());
        int start = 0; //값비교 하기 위하여

        while (n-- > 0) {
            int val = Integer.parseInt(be.readLine());
            if(val > start) {
                for(int i = start+1; i <= val; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = val;
            }
            else if(stack.peek() != val) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}