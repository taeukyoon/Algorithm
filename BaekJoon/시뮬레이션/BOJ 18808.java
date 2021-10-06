import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 BOJ 18808
 Date: 21-10-06
 */
public class Main{
    static int N, M, K, res;
    static int[][] sticker, map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < K; i++) {
             st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sticker = new int[R][C];

            for(int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < C; c++) {
                    sticker[j][c] = Integer.parseInt(st.nextToken());
                }
            }
            for(int tu = 0; tu < 4; tu++) {
                if(attach(sticker)) break;
                sticker = trun(sticker);
            }
        }
        System.out.println(res);
    }
    public static boolean attach(int[][] sticker) {
        for(int i = 0; i < N - sticker.length + 1; i++) {
            for(int j = 0; j < M - sticker[0].length + 1; j++) {
                if(check(sticker, i, j)) {
                    attachOne(sticker, i, j);
                    return true;
                }
            }
        }
        return false;
    }
    public static void attachOne(int[][] sticker, int row, int col) {
        for(int i = 0; i < sticker.length; i++) {
            for(int j = 0; j < sticker[0].length; j++) {
                if(sticker[i][j] == 1) {
                    map[row + i][col + j] = sticker[i][j];
                    res++;
                }
            }
        }
    }
    public static boolean check(int[][] sticker, int row, int col) {
        for(int i = 0; i < sticker.length; i++) {
            for(int j = 0; j < sticker[0].length; j++) {
                if(sticker[i][j] == 1 && map[row + i][col + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    static int[][] trun(int[][] sticker) {
        int[][] newSticker = new int[sticker[0].length][sticker.length];

        for(int i = 0; i < sticker.length; i++) {
            for(int j = 0; j < sticker[0].length; j++) {
                newSticker[j][sticker.length - i - 1] = sticker[i][j];
            }
        }
        return newSticker;
    }
}