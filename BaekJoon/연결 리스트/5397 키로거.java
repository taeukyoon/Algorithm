import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 BOJ 5397 키로거
 Stack 또는 Deque 사용
 */
class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            String s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                switch (ch) {
                    case '<':
                        if(!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if(!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if(!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(ch);
                }
            }
            for(Character character : left) {
                sb.append(character);
            }
            while (!right.isEmpty()){
                sb.append(right.pop());
            }
            System.out.println(sb.toString());
        }
    }
}