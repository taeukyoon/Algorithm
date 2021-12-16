import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 BOJ 20056 마법사 상어와 파이어볼
 */
public class Main {
    static int N, M, K;
    static LinkedList<FireBall>[][] map;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int res = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new LinkedList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new FireBall(m, s, d));
        }

        for (int i = 0; i < K; i++) {
            move();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (FireBall fb : map[i][j]) {
                    res += fb.m;
                }
            }
        }
        System.out.println(res);
    }

    public static void move() {
        LinkedList<FireBall> tmp[][] = new LinkedList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() >= 1) {
                    for (FireBall fb : map[i][j]) {
                        int dis = fb.s % N; //범위 밖으로 x
                        int nx = i + dx[fb.d]*dis;
                        int ny = j + dy[fb.d]*dis;

                        if (nx >= N) {
                            nx -= N;
                        }
                        else if (nx < 0) {
                            nx += N;
                        }
                        if (ny >= N) {
                            ny -= N;
                        }
                        else if (ny < 0) {
                            ny += N;
                        }
                        tmp[nx][ny].add(new FireBall(fb.m, fb.s, fb.d));
                    }
                }
            }
        }
        map = tmp;
        split();
    }

    public static void split() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() >= 2) {
                    int sSum = 0;
                    int mSum = 0;
                    boolean even = true, odd = true;

                    for (FireBall fb : map[i][j]) {
                        sSum += fb.s;
                        mSum += fb.m;
                        if (fb.d % 2 == 0) { //홀수또는 짝수
                            odd = false;
                        } else {
                            even = false;
                        }
                    }
                    int m = mSum / 5;
                    int s = sSum / map[i][j].size();
                    map[i][j].clear();


                    if (m > 0) {
                        for (int k = 0; k < 4; k++) {
                            if (even || odd) {
                                map[i][j].add(new FireBall(m, s, 0 + 2 * k));
                            } else {
                                map[i][j].add(new FireBall(m, s, 1 + 2 * k));
                            }
                        }
                    }
                }
            }
        }
    }

    static class FireBall {
        public FireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }

        int m, s, d;
    }
}