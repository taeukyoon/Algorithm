import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 BOJ 19236 청소년 상어
 */
public class Main{
    static class Shark {
        int x, y, dir, eat;

        public Shark(int x, int y, int dir, int eat) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.eat = eat;
        }
        public Shark() {

        }
    }

    static class Fish {
        int x, y, num, dir;
        boolean alive = true;

        public Fish(int x, int y, int num, int dir, boolean alive) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.alive = alive;
        }

        public Fish() {

        }
    }
    static int[][] map;
    static int res = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0,  1, 1, 1};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        List<Fish> fishes = new ArrayList<>();

        for(int i = 0; i <  4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                Fish f = new Fish();
                f.num = Integer.parseInt(st.nextToken());
                f.dir = Integer.parseInt(st.nextToken()) - 1; //0 ~ 7
                f.x = i;
                f.y = j;

                fishes.add(f);
                map[i][j] = f.num;
            }
        }

        Collections.sort(fishes, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.num - o2.num;
            }
        });

        //상어 시작위치 (0, 0)
        Fish f = fishes.get(map[0][0] -1);
        Shark shark = new Shark(0, 0, f.dir, f.num);
        f.alive = false;
        map[0][0] = -1;

        dfs(map, shark, fishes);
        System.out.println(res);
    }
    public static void dfs(int[][] map, Shark shark, List<Fish> fishes) {
        if(res < shark.eat) {
            res = shark.eat;
        }

        fishes.forEach(e -> moveFish(e, map, fishes));

        for(int k = 1; k < 4; k++) {
            int nx = shark.x + dx[shark.dir] * k;
            int ny = shark.y + dy[shark.dir] * k;

            if(nx >= 0 && ny >= 0 && nx < 4 &&  ny < 4 && map[nx][ny] != 0) {

                int[][] mapCopy = copyMap(map);
                List<Fish> fishCopy = copyFishes(fishes);

                mapCopy[shark.x][shark.y] = 0;
                Fish f = fishCopy.get(map[nx][ny] - 1);
                Shark curShark = new Shark(f.x, f.y, f.dir, shark.eat + f.num);
                f.alive = false;
                mapCopy[f.x][f.y] = -1;

                dfs(mapCopy, curShark, fishCopy);
            }
        }
    }


    public static void moveFish(Fish fish, int[][] map, List<Fish> fishes) {
        if(fish.alive == false) return;

        for(int i = 0; i < 8; i++) {
            int nDir = (fish.dir + i) % 8; //방향 범위
            int nx = fish.x + dx[nDir];
            int ny = fish.y + dy[nDir];

            if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && map[nx][ny] != -1) {
                map[fish.x][fish.y] = 0;

                if(map[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish tmp = fishes.get(map[nx][ny] - 1);
                    tmp.x = fish.x;
                    tmp.y = fish.y;
                    map[fish.x][fish.y] = tmp.num;

                    fish.x = nx;
                    fish.y = ny;
                }

                map[nx][ny] = fish.num;
                fish.dir = nDir;
                return;
            }
        }
    }
    public static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[4][4];

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                tmp[i][j] = map[i][j];
            }
        } return tmp;
    }

    public static List<Fish> copyFishes(List<Fish> fishes) {
        List<Fish> tmp = new ArrayList<>();
        fishes.forEach(e -> tmp.add(new Fish(e.x, e.y, e.num, e.dir, e.alive)));
        return tmp;
    }
}