import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 BOJ 18258 큐2
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        LinkedList<String> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if("pop".equals(input)) {
                sb.append(queue.isEmpty() ?"-1" : queue.poll()).append('\n');
            }else if(input.startsWith("p")) {
                queue.add(input.substring(input.indexOf(' ')+1));
            }else if(input.startsWith("s")) {
                sb.append(queue.size()).append('\n');
            }else if(input.startsWith("e")) {
                sb.append(queue.isEmpty() ? "1" : "0").append('\n');
            }else if(input.startsWith("f")) {
                sb.append(queue.isEmpty() ? "-1" : queue.getFirst()).append('\n');
            }else if(input.startsWith("b")) {
                sb.append(queue.isEmpty() ? "-1" : queue.getLast()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
