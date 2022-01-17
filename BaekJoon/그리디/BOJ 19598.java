import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
  BOJ 19598 최소 회의실 개수
  Greedy
 */
public class Main {
    static int N;
    static class Conference {
        int s, e;

        public Conference(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Conference[] c = new Conference[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            c[i] = new Conference(start, end);
        }
        Arrays.sort(c, (((o1, o2) -> o1.s == o2.s ? o1.e - o2.e : o1.s - o2.s)));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(c[0].e);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= c[i].s) {
                pq.poll();
            }
            pq.offer(c[i].e);
        }
        System.out.println(pq.size());
    }
}
