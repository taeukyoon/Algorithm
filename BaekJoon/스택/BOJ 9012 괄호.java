import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 BOJ 9012 괄호
 */
class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Stack<Character> stack = new Stack<>();

            String s = br.readLine();
            boolean b = true;

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c == '(') {
                    stack.push('(');
                }else {
                    if(stack.isEmpty()) {
                        b = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(b && stack.isEmpty()) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}