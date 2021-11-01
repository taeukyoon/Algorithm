import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 17281
 순열, 시물레이션
 */
public class Main {
    static int N;
    static int[][] hitter;
    static boolean[] selected;
    static int[] lineUp;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        hitter = new int[N + 1][10];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                hitter[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        selected = new boolean[10];
        lineUp = new int[10];

        selected[4] = true; //4번타자 1번 고정
        lineUp[4] = 1; //4번 타자는 1번

        perm(2);
        System.out.println(res);
    }

    public static void perm(int num) {
        if (num == 10) {
            game();
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            lineUp[i] = num;
            perm(num + 1);
            selected[i] = false;
        }
    }

    public static void game() {
        int score = 0;
        int startPlayer = 1;
        boolean[] base;

        for (int i = 1; i <= N; i++) {
            int outCount = 0;
            base = new boolean[4];

            restart:
            while (true) {
                for (int j = startPlayer; j <= 9; j++) {
                    int player = hitter[i][lineUp[j]];

                    switch (player) {
                        case 0: //out
                            outCount++;
                            break;
                        case 1: //안타
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    if (k == 3) { //홈인
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }
                                    base[k] = false; //베이스 한칸씩 앞으로
                                    base[k + 1] = true;
                                }
                            }
                            base[1] = true;
                            break;

                        case 2: //2루타
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    if (k == 2 || k == 3) { //2루 또는 3루일경우
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }
                                    base[k] = false;
                                    base[k + 2] = true;
                                }
                            }
                            base[2] = true;
                            break;

                        case 3: //3루타
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            base[3] = true;
                            break;
                        case 4: //홈런
                            for (int k = 1; k <= 3; k++) {
                                if (base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            score++;
                            break;
                    }
                    if (outCount == 3) { //아웃 카운터가 3일때
                        startPlayer = j + 1;
                        if (startPlayer == 10) {
                            startPlayer = 1;
                        }
                        break restart;
                    }
                }
                startPlayer = 1; //아웃이 하나도 없을
            }
            res = Math.max(res, score);
        }
    }
}