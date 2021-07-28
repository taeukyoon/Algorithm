import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 BOJ 4949 균형잡힌 세상
 간단한 규칙 (())가 예시로 있으면 (( 열리는것들은 스택에 넣어주고 ) 닫히는게 나오면 바로 전의꺼를 꺼내서 맞는 한 쌍인지 비교를
 한다. (( -> (() -> ()한쌍제거 -> () 한쌍제거
 */
class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if(s.equals(".")) {
                break;
            }
            sb.append(result(s)).append('\n');
        }
        System.out.println(sb);
    }
    public static String result(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[') {
                stack.push(c);
            }

            else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }else stack.pop();
            }
            else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }else stack.pop();
            }
        }
        if(stack.empty()) {
            return "yes";
        }else return "no";
    }
}