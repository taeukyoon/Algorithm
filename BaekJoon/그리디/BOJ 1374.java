import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture>{
    int num, s, e;

    public Lecture(int num, int s, int e) {
        this.num = num;
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.s == o.s) {
            return this.e - o.e;
        }
        return this.s - o.s;
    }
}

/*
 BOJ 1374 강의실
 */
public class Main {
    static int n;
    static Lecture[] lectures;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(num, s, e);
        }
        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].e);

        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= lectures[i].s) {
                pq.poll();
            }
            pq.offer(lectures[i].e);
        }
        System.out.println(pq.size());
    }
}
