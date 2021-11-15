import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C, M, res;
    static Shark[][] sharks;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharks = new Shark[R][C];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            Shark shark = new Shark();
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            shark.speed = Integer.parseInt(st.nextToken());
            shark.dir = Integer.parseInt(st.nextToken());
            shark.size = Integer.parseInt(st.nextToken());

            sharks[r -1][c - 1] = shark;
        }

        process();
        System.out.println(res);
    }

    public static void process() {
        for(int i = 0; i < C; i++) {
            fishing(i);
            sharkMove();
        }
    }

    public static void fishing(int col) { //낚시꾼이 있는열에 있는거 다잡는다.
        for(int i = 0; i < R; i++) {
            if(sharks[i][col] != null) {
                res += sharks[i][col].size;
                sharks[i][col] = null;
                return;
            }
        }
    }

    public static void sharkMove() {
        Shark[][] nextShark = new Shark[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                move(nextShark, i, j);
            }
        }

        for(int i = 0; i < R; i++) {
            sharks[i] = Arrays.copyOf(nextShark[i], C);
        }
    }

    public static void move(Shark[][] nextShark, int r, int c) {
        Shark shark = sharks[r][c];

        if(shark == null) {
            return;
        }

        int x = shark.dir < 3 ? R : C;
        int distance = shark.speed % ((x - 1) * 2);
        int row = r;
        int col = c;

        for(int k = 0; k < distance; k++) {
            if(shark.dir == 1) {
                row--;
                if(row < 0) {
                    shark.dir = 2;
                    row = 1;
                }
            } else if (shark.dir == 2) {
                row++;
                if(row > R - 1) {
                    shark.dir = 1;
                    row = R - 2;
                }
            } else if(shark.dir == 3) {
                col++;
                if(col > C - 1) {
                    shark.dir = 4;
                    col = C - 2;
                }
            } else {
                col--;
                if(col < 0) {
                    shark.dir = 3;
                    col = 1;
                }
            }
        }
        if (nextShark[row][col] != null && nextShark[row][col].size > shark.size) {
            return;
        }

        nextShark[row][col] = shark;
    }
}

class Shark {
    int speed, dir, size;
}