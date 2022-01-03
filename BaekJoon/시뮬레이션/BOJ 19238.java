import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 BOJ 19238
 */
public class Main {
    static int N, M, fuel;
    static int[][] map;
    static Taxi taxi;
    static Map<Integer, Passenger> psMap = new HashMap<>();
    static Passenger exsit = null;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[21][21];

        //활동 영역
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //택시 시작위치
        st = new StringTokenizer(br.readLine());
        taxi = new Taxi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);


        //승객 위치
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            Passenger p = new Passenger();
            p.sx = Integer.parseInt(st.nextToken());
            p.sy = Integer.parseInt(st.nextToken());
            p.fx = Integer.parseInt(st.nextToken());
            p.fy = Integer.parseInt(st.nextToken());
            p.num = i + 1;

            psMap.put(i + 1, p);
            map[p.sx][p.sy] = p.num;
        }
        solve();
    }
    //bfs(최소거리) -> 목적지 도착 -> 연료확인 -> 다시 승객 출발지 -> 목적지 도착 -> 연료 확인
    public static void solve() {
        while (!psMap.isEmpty()) {
            int totalStartFuel = bfs();
            fuel -= totalStartFuel;

            if (fuel < 0) break;

            int totalDestFuel = bfs();
            fuel -= totalDestFuel;

            if (fuel < 0) break;

            fuel += totalDestFuel * 2;
        }
        System.out.println(fuel < 0 ? -1 : fuel);
    }

    public static int bfs() {
        Queue<Taxi> qu = new LinkedList<>();
        Queue<Passenger> ps = new LinkedList<>();
        boolean[][] visited = new boolean[21][21];

        int move = taxi.move;;
        visited[taxi.x][taxi.y] = true;
        qu.add(taxi);

        while (!qu.isEmpty()) {
            Taxi cur = qu.poll();

            if (fuel - cur.move < 0) {
                return Integer.MAX_VALUE;
            }

            if (move != cur.move && !ps.isEmpty()) break;

            move = cur.move;

            //택시에 승객이 없을 때
            if (exsit == null) {
                int num = map[cur.x][cur.y];

                if (num > 1) {
                    Passenger p = psMap.get(num);
                    ps.add(p);
                 }
            } else {
                if (cur.x == exsit.fx && cur.y == exsit.fy) {
                    psMap.remove(exsit.num);
                    exsit = null;
                    taxi = new Taxi(cur.x, cur.y, 0);
                    return move;
                }
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx > 0 && ny > 0 && nx <= N && ny <= N) {
                    if (map[nx][ny] != 1 &&  !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        qu.add(new Taxi(nx, ny, cur.move + 1));
                    }
                }
            }
        }

        if (ps.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        exsit = findNearest(ps);
        taxi = new Taxi(exsit.sx, exsit.sy, 0);
        map[exsit.sx][exsit.sy] = 0;
        return move;
    }

    public static Passenger findNearest(Queue<Passenger> q) {
        Passenger target = q.poll();

        while (!q.isEmpty()) {
            Passenger compare = q.poll();

            if(compare.sx < target.sx) {
                target = compare;
            } else if (compare.sx == target.sx && compare.sy < target.sy) {
                target = compare;
            }
        }
        return target;
    }


    //택시
    static class Taxi {
        int x, y, move;

        public Taxi(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    //승객
    static class Passenger {
        int num, sx, sy, fx, fy;

        Passenger() {}

        public Passenger(int num, int sx, int sy, int fx, int fy) {
            this.num = num;
            this.sx = sx;
            this.sy = sy;
            this.fx = fx;
            this.fy = fy;
        }


    }
}