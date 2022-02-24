import java.io.IOException;
import java.util.Scanner;

/*
 BOJ 2578 빙고
 */
public class Main {
    static final int WIDTH = 5;
    static int[][] bingo;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        bingo = new int[WIDTH][WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                bingo[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= 25; i++) {
            int num = sc.nextInt();

            for (int a = 0; a < WIDTH; a++) {
                for (int b = 0; b < WIDTH; b++) {
                    if (bingo[a][b] == num) {
                        bingo[a][b] = -1;

                        if (checkArena() >= 3) {
                            System.out.println(i);
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }
    public static int checkArena() {
        int bingoCnt = 0;
        //가로
        for (int i = 0; i < WIDTH; i++) {
            int Rcount = 0;
            for (int j = 0; j < WIDTH; j++) {
                if (bingo[i][j] == -1) Rcount++;
            }
            if (Rcount == 5) bingoCnt++;
        }
        //세로
        for (int i = 0; i < WIDTH; i++) {
            int Colcount = 0;
            for (int j = 0; j < WIDTH; j++) {
                if (bingo[j][i] == -1) Colcount++;
            }
            if (Colcount == 5) bingoCnt++;
        }
        //왼 - 오 대각
        int count1 = 0;
        for (int i = 0; i < WIDTH; i++) {
            if (bingo[i][i] == -1) count1++;
            if (count1 == 5) bingoCnt++;
        }

        //오 - 왼 대각
        count1 = 0;
        for (int i = 0; i < WIDTH; i++) {
            if (bingo[i][4 - i] == -1) count1++;
            if (count1 == 5) bingoCnt++;
        }
        return bingoCnt;
    }
}
