import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 BOJ 10866 덱
 */

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            switch (input) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(!deque.isEmpty()) {
                        System.out.println(deque.removeFirst());
                    }else System.out.println(-1);
                    break;
                case "pop_back":
                    if(!deque.isEmpty()) {
                        System.out.println(deque.removeLast());
                    }else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if(!deque.isEmpty()){
                        System.out.println(0);
                    }else System.out.println(1);
                    break;
                case "front":
                    if(!deque.isEmpty()){
                        System.out.println(deque.getFirst());
                    }else System.out.println(-1);
                    break;
                case "back":
                    if(!deque.isEmpty()){
                        System.out.println(deque.getLast());
                    }else System.out.println(-1);
                    break;
            }
        }



    }
}
