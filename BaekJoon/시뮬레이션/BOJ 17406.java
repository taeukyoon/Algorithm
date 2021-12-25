import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 17406 배열 돌리기4
 */
public class Main{
    static int n, m, k;
    static int[][] arr, copyArr, rotation;
    static boolean[] visited;
    static int[] res;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        copyArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                copyArr[i][j] = arr[i][j];
            }
        }

        rotation = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rotation[i][0] = Integer.parseInt(st.nextToken());
            rotation[i][1] = Integer.parseInt(st.nextToken());
            rotation[i][2] = Integer.parseInt(st.nextToken());
        }

        res = new int[k];
        visited = new boolean[k];
        perm(0, k);
        System.out.println(ans);
    }
    public static void perm(int idx, int k) {
        if (idx == k) {
            init();
            findMin();
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[idx] = i;
                perm(idx + 1, k);
                visited[i] = false;
            }
        }
    }

    public static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = copyArr[i][j];
            }
        }
    }

    public static void findMin() {
        for (int i = 0; i < res.length; i++) {
            int lx = rotation[res[i]][0] - rotation[res[i]][2] - 1;
            int ly = rotation[res[i]][1] - rotation[res[i]][2] - 1;
            int rx = rotation[res[i]][0] + rotation[res[i]][2] - 1;
            int ry = rotation[res[i]][1] + rotation[res[i]][2] - 1;

            rotate(lx, ly, rx, ry);
        }
        calculate();
    }

    public static void calculate() {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            ans = Math.min(ans, sum);
        }
    }

    public static void rotate(int lx, int ly, int rx, int ry) {
        if (lx == rx && ly == ry) {
            return;
        }

        //모서리 부분 값저장
        int[] tmp = new int[3];
        tmp[0] = arr[lx][ry];
        tmp[1] = arr[rx][ry];
        tmp[2] = arr[rx][ly];

        //오른쪽
        for (int i = ry; i > ly; i--) {
            arr[lx][i] = arr[lx][i - 1];
        }

        //아래
        for (int i = rx; i > lx; i--) {
            if (i == lx + 1) arr[i][ry] = tmp[0];
            else arr[i][ry] = arr[i - 1][ry];
        }

        for (int i = ly; i < ry; i++) {
            if (i == ry -1) arr[rx][i] = tmp[1];
            else arr[rx][i] = arr[rx][i + 1];
        }

        for (int i = lx; i < rx; i++) {
            if (i == rx - 1) arr[i][ly] = tmp[2];
            else arr[i][ly] = arr[i + 1][ly];
        }
        rotate(lx + 1, ly + 1, rx - 1, ry - 1); //안쪽
    }
}