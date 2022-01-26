import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 BOJ 1946 신입사원
 */
public class Main {
    static int T, n;
    static ArrayList<Player> list;

    static class Player implements Comparable<Player> {
        int score, interview;

        Player(int score, int interview) {
            this.score = score;
            this.interview = interview;
        }

        @Override
        public int compareTo(Player o) {
            return this.score - o.score;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                list.add(new Player(s, e));
            }
            Collections.sort(list);

            int cnt = 1;
            int min = list.get(0).interview;
            for (int a = 1; a < n; a++) {
                if (list.get(a).interview < min) {
                    cnt++;
                    min = list.get(a).interview;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
