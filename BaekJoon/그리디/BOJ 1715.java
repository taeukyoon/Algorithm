import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


/*
 BOJ 1715 카드 정렬하기
 */
public class Main {
    static int n;
    static PriorityQueue<Long> pq;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long sum = 0, res = 0;
        while (pq.size() > 1) {
            sum = pq.poll() + pq.poll();
            res += sum;

            pq.add(sum);
        }
        System.out.println(res);
    }
}
