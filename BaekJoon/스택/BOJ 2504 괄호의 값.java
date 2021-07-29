import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 BOJ 2504 괄호의 값
 */
class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int num = 1, result = 0;

        for(int i = 0 ; i < s.length(); i++) {
            char c  = s.charAt(i);
            switch (c) {
                case '(':
                    stack.push('(');
                    num *= 2;
                    break;

                case '[':
                    stack.push('[');
                    num *= 3;
                    break;

                case ')':
                    if(stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        break;
                    }

                    else if(s.charAt(i - 1) == '(') {
                        result += num;
                    }
                        stack.pop();
                        num /= 2;
                        break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        break;
                    }

                    else if(s.charAt(i - 1) == '[') {
                        result += num;
                    }
                        stack.pop();
                        num /= 3;
                        break;

            }
        }
        System.out.println(!stack.isEmpty() ? 0 : result);
    }
}