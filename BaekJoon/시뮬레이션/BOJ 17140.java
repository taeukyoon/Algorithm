import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 BOJ 17140
 Date: 21-11-11
 */
public class Main{
    static int r, c, k;
    static int[][] arr;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        arr = new int[101][101];

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = -1;
        int rowSize = 3 , colSize = 3;

        while (++time <= 100) {
            if(arr[r][c] == k) break;

            if(rowSize >= colSize) {
                int maxN = 0;

                for(int i = 0; i < rowSize; i++) {
                    int[] num = new int[101];
                    for(int j = 0; j < colSize; j++) {
                        num[arr[i][j]]++;
                        arr[i][j] = 0;
                    }

                    PriorityQueue<Pair> pq = new PriorityQueue<>();
                    for(int j = 1; j <= 100; j++) {
                        if (num[j] != 0) {
                            pq.add(new Pair(j, num[j]));
                        }
                    }

                    int idx = 0;
                    while (!pq.isEmpty()) {
                        Pair p = pq.poll();
                        arr[i][idx++] = p.num;
                        arr[i][idx++] = p.cnt;
                    }

                    if(maxN < idx) maxN = idx;
                }
                colSize = maxN;
            }
            else {
                int maxM = 0;

                for(int i = 0; i < colSize; i++) {
                    int[] num = new int[101];
                    for(int j = 0; j < rowSize; j++) {
                        num[arr[j][i]]++;
                        arr[j][i] = 0;
                    }

                    PriorityQueue<Pair> pq = new PriorityQueue<>();

                    for(int j = 1; j <= 100; j++) {
                        if(num[j] != 0) {
                            pq.add(new Pair(j, num[j]));
                        }
                    }

                    int idx = 0;
                    while (!pq.isEmpty()) {
                        Pair p = pq.poll();
                        arr[idx++][i] = p.num;
                        arr[idx++][i] = p.cnt;
                    }
                    if(maxM < idx) maxM = idx;
                }
                rowSize = maxM;
            }
        }
        if(time == 101) System.out.println(-1);
        else System.out.println(time);
    }
}
class Pair implements Comparable<Pair>{
    public Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    int num, cnt;

    public int compareTo(Pair o) {
        if(cnt == o.cnt) {
            return num - o.num;
        } else {
            return cnt - o.cnt;
        }
    }
}