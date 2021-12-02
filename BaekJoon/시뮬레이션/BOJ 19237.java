import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 BOJ 19237 어른 상어
 */
public class Main {
    static int N, M, k;
    static int[][] map;
    static int[][] owner;
    static int[][] smell;
    static Map<Integer, Shark> sharks = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        owner = new int[N][N];
        smell = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] != 0) {
                    Shark shark = new Shark();
                    shark.x = i;
                    shark.y = j;
                    shark.num = map[i][j];
                    sharks.put(shark.num, shark);

                    smell[i][j] = k;
                    owner[i][j] = shark.num;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            Shark shark = sharks.get(i);
            shark.dir = Integer.parseInt(st.nextToken());
        }


        for(int i = 1; i <= M; i++) {
            Shark shark = sharks.get(i);
            for(int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for(int z = 0; z < 4; z++) {
                    shark.priority[j + 1][z + 1] = Integer.parseInt(st.nextToken());
                }
            }
        }

        solve();
    }
    public static void solve() {
        int time = 0;

        while (time++ < 1000) {
            moveShark();
            decreaseSmell();
            createSmell();

            if(sharks.size() == 1) {
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void moveShark() {
        Queue<Integer> remove = new LinkedList<>();

        for (Integer id : sharks.keySet()) {
            Set<Integer> noSmell = new HashSet<>();
            Set<Integer> mySmell = new HashSet<>();
            Shark shark = sharks.get(id);

            for(int k = 0; k < 4; k++) {
                int nx = shark.x + dx[k];
                int ny = shark.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if(owner[nx][ny] == 0) {
                    noSmell.add(k + 1);
                } else if(owner[nx][ny] == shark.num) {
                    mySmell.add(k + 1);
                }
            }

            int nextDir = shark.findNextDir(noSmell);

            if(nextDir == 0) {
                nextDir = shark.findNextDir(mySmell); //자신이 있는 칸의 냄새
            }

            map[shark.x][shark.y] = 0;

            //위, 아래, 왼, 오
            if(nextDir == 1) {
                shark.x -= 1;
            } else if(nextDir == 2) {
                shark.x += 1;
            } else if (nextDir == 3) {
                shark.y -= 1;
            } else if (nextDir == 4) {
                shark.y += 1;
            }

            if(map[shark.x][shark.y] == 0 || shark.num < map[shark.x][shark.y]) {
                map[shark.x][shark.y] = shark.num;
                shark.dir = nextDir;
            } else {
                remove.add(shark.num);
            }
        }
        while (!remove.isEmpty()) {
            sharks.remove(remove.poll());
        }
    }
    public static void decreaseSmell() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (smell[i][j] == 0)  continue;;

                smell[i][j]--;

                if(smell[i][j] == 0) {
                    owner[i][j] = 0;
                }
            }
        }
    }

    public static void createSmell() {
        for (Integer id : sharks.keySet()) {
            Shark shark = sharks.get(id);

            owner[shark.x][shark.y] = shark.num;
            smell[shark.x][shark.y] = k;
        }
    }

    static class Shark {
        int num, x, y, dir; //번호, 좌표, 방향

        Shark () {
        }

        public Shark(int num, int x, int y, int dir) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        int[][] priority = new int[5][5]; //방향, 우선방향

        public int findNextDir(Set<Integer> set) {
            for(int i = 1; i <= 4; i++) {
                if (set.contains(priority[dir][i])) {
                    return priority[dir][i];
                }
            }
            return 0;
        }
    }
}
