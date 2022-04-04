import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 5766 할아버지는 유명해!
 */
public class Main {
    static int n, m;
    static class Player implements Comparable<Player>{
        int num;
        int score;

        public Player(int num, int score) {
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Player o) {
            if (this.score == o.score) {
                return this.num - o.num;
            }
            return o.score - this.score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Player[] players = new Player[10001];
            for (int i = 0; i < 10001; i++) {
                players[i] = new Player(i, 0);
            }

            if (n == 0 && m == 0) break;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(),  " ");
                for (int j = 0; j < m; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    players[num].score++;
                }
            }

            Arrays.sort(players);
            for (int i = 0; i < 10001; i++) {
                if (players[i].score == players[1].score) {
                    sb.append(players[i].num).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
