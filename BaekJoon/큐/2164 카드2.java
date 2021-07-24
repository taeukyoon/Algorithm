import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 BOJ 2164 카드2
 큐사용
 */
public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <=n; i++) {
            queue.offer(i); //123456
        }
        while (queue.size() > 1) {
                queue.poll();
                queue.offer(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
