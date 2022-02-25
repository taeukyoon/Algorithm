import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 10994 별 찍기 - 19
 */
public class Main {
    static char[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int range = (n - 1) * 4 + 1;
        star = new char[range + 1][range + 1];

        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= range; j++) {
                star[i][j] = ' ';
            }
        }
        draw(1, range);

        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= range; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }
    public static void draw(int s, int range) {
        for (int i = s; i <= range; i++) {
            star[s][i] = '*';
            star[range][i] = '*';
            star[i][s] = '*';
            star[i][range] = '*';
        }

        if (range == 1) return;
        draw(s + 2, range - 2);
    }
}
