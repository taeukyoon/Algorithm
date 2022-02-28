import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 17276 배열 돌리기
 */
public class Main {
    static int T, n, d;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            arr = new int[n + 1][n + 1];

            for (int r = 1; r <= n; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= n; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] copyArr = copy(arr);
            rotate(d, copyArr);
        }
    }

    public static void rotate(int d, int[][] arr) {
        int[][] copyArr = copy(arr);
        int[][] copyArr2 = copy(arr);
        // 시계방향
        if (d > 0) {
            for (int c = 0; c < Math.abs(d) / 45; c++) {
                //왼 -----> 오 순서
                for (int i = 1; i <= n; i++) {
                    copyArr[i][(n + 1) / 2] = arr[i][i];
                }
                for (int i = 1; i <= n; i++) {
                    copyArr[i][n - i + 1] = arr[i][(n + 1) / 2];
                }
                for (int i = 1; i <= n; i++) {
                    copyArr[(n + 1) / 2][n - i + 1] = arr[i][n - i + 1];
                }
                for (int i = 1; i <= n; i++) {
                    copyArr[i][i] = arr[(n + 1) / 2][i];
                }
                arr = copy(copyArr);
            }
        } else if (d < 0) {
            for (int c = 0; c < Math.abs(d) / 45; c++) {
                //오 -----> 왼
                for (int i = 1; i <= n; i++) {
                    copyArr2[(n + 1) / 2][i] = arr[i][i];
                }
                for (int i = 1; i <= n; i++) {
                    copyArr2[i][i] = arr[i][(n + 1) / 2];
                }
                for (int i = 1; i <= n; i++) {
                    copyArr2[i][(n + 1) / 2] = arr[i][(n - i + 1)];
                }
                for (int i = 1; i <= n; i++) {
                    copyArr2[n - i + 1][i] = arr[(n + 1) / 2][i];
                }
                arr = copy(copyArr2);
            }
        }
        print(arr);
    }

    public static void print(int[][] arr) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] copy(int[][] arr) { //배열복사
        int[][] copyArr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }
        return copyArr;
    }
}
