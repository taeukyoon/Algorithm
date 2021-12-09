import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 20055
 */
public class Main {
    static int N, K, cnt;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[N*2];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            moveBelt();
            cnt++;
            moveRobot();
            if (check()) {
                System.out.println(cnt);
                break;
            }
        }
    }

    public static void moveBelt() {
        int end = belt[belt.length - 1];

        for (int i = belt.length - 2; i >= 0; i--) {
            belt[i+1] = belt[i];
        }
        belt[0] = end;

        for (int i = N - 2; i >= 0; i--) {
            robot[i+1] = robot[i];
        }
        robot[0] = false;
    }

    public static void moveRobot() {
        if (robot[N - 1]) { //내리는 위치
            robot[N - 1] = false;
        }

        for (int i = N-2; i > 0; i--) {
            if (robot[i] && !robot[i+1] && belt[i+1] > 0) {
                robot[i+1] = true;
                robot[i] = false;
                belt[i+1]--;
            }
        }

        if (belt[0] > 0 && !robot[0]) {
            robot[0] = true;
            belt[0]--;
        }
    }

    public static boolean check() { //끝나면 true 내구도가 0인 벨트가 k개면
        int count = 0;

        for (int i = 0; i < belt.length; i++) {
            if(belt[i] == 0) {
                count++;
            }
        }

        if (count >= K) {
            return true;
        } else {
            return false;
        }

    }
}