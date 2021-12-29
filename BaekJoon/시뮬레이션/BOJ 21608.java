import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2 {
    static int n, ans;
    static int[][] map;
    static int[][] emptyMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Integer, Student> list = new HashMap<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int size = n * n;
        map = new int[n][n];
        emptyMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 4;
                if (i == 0 || i == n - 1) cnt--;
                if (j == 0 || j == n - 1) cnt--;
                emptyMap[i][j] = cnt;
            }
        }

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            int f3 = Integer.parseInt(st.nextToken());
            int f4 = Integer.parseInt(st.nextToken());

            findSeat(num, new int[] {f1, f2, f3, f4});
        }

        for (int i = 1; i <= size; i++) {
            Student student = list.get(i);
            int cnt = 0;

            for (int friend : student.like) {
                if (Math.abs(list.get(friend).x - student.x) + Math.abs(list.get(friend).y - student.y) == 1) {
                    cnt++;
                }
            }
            if (cnt == 1) ans += 1;
            else if (cnt == 2) ans += 10;
            else if (cnt == 3) ans += 100;
            else if (cnt == 4) ans += 1000;
        }
        System.out.println(ans);
    }
    public static void findSeat(int num, int[] friends) {
        int[][] prefer = new int[n][n];
        for (int friend : friends) {
            if (list.containsKey(friend)) {
                Student s = list.get(friend);
                int x = s.x;
                int y = s.y;

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (check(nx, ny)) continue;
                    if (map[nx][ny] == 0) {
                        prefer[nx][ny]++;
                    }
                }
            }
        }

        int emptyMax = -1;
        int preferMax = -1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) continue;

                if (preferMax < prefer[i][j]) {
                    x = i;
                    y = j;
                    preferMax = prefer[i][j];
                    emptyMax = emptyMap[i][j];
                } else if (preferMax == prefer[i][j] && emptyMax < emptyMap[i][j]) {
                    x = i;
                    y = j;
                    emptyMax = emptyMap[i][j];
                }
            }
        }
        map[x][y] = num;
        list.put(num, new Student(x, y, friends));

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (check(nx, ny)) continue;

            if (map[nx][ny] == 0) {
                prefer[nx][ny]--;
            }
        }
    }

    public static boolean check(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= n || ny >= n;
    }

    static class Student {
        int x, y, like[];

        public Student(int x, int y, int[] like) {
            this.x = x;
            this.y = y;
            this.like = like;
        }
    }
}
