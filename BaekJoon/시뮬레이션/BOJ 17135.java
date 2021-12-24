import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 17135 캐슬 디펜스
 */
public class Main{
    static int n, m, d, ans;
    static int[][] map, copyMap;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        copyMap = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];
            }
        }

        ans = 0;
        ArrayList<Integer> archer = new ArrayList<>();
        comb(1, 3, archer);

        System.out.println(ans);
    }

    public static void init() { //맵초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }

    public static int distance(int r1, int r2, int c1, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public static void comb(int start, int r, ArrayList<Integer> archer) {
        if (r == 0) {
            init();
            attack(archer);
            return;
        }

        for (int i = start; i <= m; i++) {
            archer.add(i);
            comb(i + 1, r - 1, archer);
            archer.remove(archer.size() - 1);
        }
    }

    public static void attack(ArrayList<Integer> archer) {
        int res = 0;

        for (int a = 1; a <= n; a++) {
            boolean[][] visited = new boolean[n+1][m+1];
            for (int b = 0; b < archer.size(); b++) {
                int minD = Integer.MAX_VALUE;
                int minR = Integer.MAX_VALUE;
                int minC = Integer.MAX_VALUE;
                int tmp = archer.get(b);

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == 1) { //적이 있으면
                            if (minD >= distance(i, n + 1, j, tmp)) {
                                if (minD > distance(i, n + 1, j, tmp)) {
                                    minD = distance(i, n + 1, j, tmp);
                                    minR = i;
                                    minC = j;
                                } else { //가장 왼쪽부터
                                    if (minC > j) {
                                        minR = i;
                                        minC = j;
                                    }
                                }
                            }
                        }
                    }
                }

                if (minD <= d) {
                    visited[minR][minC] = true;
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (visited[i][j]) {
                        map[i][j] = 0;
                        res++;
                    }
                }
            }

            for (int i = 1; i <= m; i++) { //성 윗줄 초기화
                map[n][i] = 0;
            }

            for (int i = n; i >= 1; i--) { // i번째 줄을 i-1
                for (int j = 1; j <= m; j++) {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        ans = Math.max(ans, res);
    }
}