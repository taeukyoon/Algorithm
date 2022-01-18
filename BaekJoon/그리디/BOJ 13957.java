import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 BOJ 13957 파일 합치기3
 */
public class Main {
    static int t, k;
    static PriorityQueue<Long> pq;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            long res = 0;
            while (true) {
                long num1 = pq.poll();
                long num2 = pq.poll();

                sum = num1 + num2;
                res += sum;

                if (pq.isEmpty()) {
                    break;
                }
                pq.add(sum);
            }
            System.out.println(res);
        }
    }
}
