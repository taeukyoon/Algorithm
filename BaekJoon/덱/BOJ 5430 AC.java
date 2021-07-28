import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
 BOJ 5430 AC
 덱을 이용한 풀이, 배열을 뒤집는 방법이아니라 배열에 방향을줘서 풀이한다.
 */
class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
            for(int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(p, deque);
        }
        System.out.println(sb);
    }

    public static void AC(String p, ArrayDeque<Integer> deque) {
        boolean right = true;
        for(char cmd : p.toCharArray()) {
            if(cmd == 'R') {
                right = !right;
                continue;
            }
            if(cmd == 'D') {
                if(deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                }
                if(right) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }
        makePrint(deque, right);
    }

    public static void makePrint(ArrayDeque<Integer> deque, boolean right) {
        sb.append('[');
        if(!deque.isEmpty()) {
            if(right) {
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }
}