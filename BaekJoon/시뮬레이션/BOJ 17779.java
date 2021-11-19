import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 17779
 Date: 21-11-19
 */
public class Main {
    static int N;
    static int[][] arr;
    static int sum = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum += arr[i][j];
            }
        }

        divide(); //경계선 나누기
        System.out.println(min);
    }
    public static void divide() {
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                for(int d1 = 1; d1 < N; d1++) {
                    for(int d2 = 1; d2 < N; d2++) {
                        //범위 초과
                        if(x + d1 + d2 >= N) continue;
                        if(y - d1 < 0 || y + d2 >= N) continue;

                        solve(x, y, d1, d2);
                    }
                }
            }
        }
    }

    public static void solve(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[N][N];
        int[] totalPeople = new int[5];

        //경계선
        for(int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for(int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        //1구역
        for(int i = 0; i < x + d1; i++) {
            for(int j = 0; j <= y; j++) {
                if(border[i][j]) break;
                totalPeople[0] += arr[i][j];
            }
        }
        //2
        for(int i = 0; i <= x + d2; i++) {
            for(int j = N - 1; j > y; j--) {
                if(border[i][j])break;
                totalPeople[1] += arr[i][j];
            }
        }
        //3
        for(int i = x + d1; i < N; i++) {
            for(int j = 0; j < y - d1 + d2; j++) {
                if(border[i][j]) break;
                totalPeople[2] += arr[i][j];
            }
        }
        //4
        for(int i = x + d2 + 1; i < N; i++) {
            for(int j = N - 1; j >= y -d1 + d2; j--) {
                if(border[i][j]) break;
                totalPeople[3] += arr[i][j];
            }
        }

        totalPeople[4] = sum;

        for(int i = 0; i < 4; i++) {
            totalPeople[4] -= totalPeople[i];
        }

        Arrays.sort(totalPeople);
        min = Math.min(min, totalPeople[4] - totalPeople[0]);
    }
}
