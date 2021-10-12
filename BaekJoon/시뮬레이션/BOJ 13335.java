import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 13335 트럭
 Date: 21-10-12
 */
public class Main {
    static int n, m, w, L;
    static Queue<Integer> truck;
    static Queue<Integer> qu;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        truck = new LinkedList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        int weight = 0;
        qu = new LinkedList<>();
        for(int i = 0; i < w; i++) {
            qu.add(0);
        }
        while(!qu.isEmpty()) {
            cnt++;
            weight -= qu.poll();
            if(!truck.isEmpty()) {
                if(truck.peek()+weight <= L) {
                    weight += truck.peek();
                    qu.offer(truck.poll());
                } else {
                    qu.offer(0);
                }
            }
        }
        System.out.println(cnt);

    }
}