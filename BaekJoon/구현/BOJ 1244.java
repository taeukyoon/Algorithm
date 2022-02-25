import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1244 스위치 켜고 끄기
 */
public class Main {
    static int n, student;
    static int[] state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        state = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            control(gender, val);
        }

        print();
    }

    public static void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(state[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

    public static void control(int g, int v) {
        if (g == 1) { //남자
            for (int i = 1; i <= n; i++) {
                if (i % v == 0) {
                    state[i] = state[i] == 1 ? 0 : 1;
                }
            }
        } else if (g == 2) { //여자
            if ((v == 1 || v == n) || state[v - 1] != state[v + 1]) {
                state[v] = state[v] == 1 ? 0 : 1;
            } else {
                int r = v + 1;
                int l = v - 1;
                state[v] = state[v] == 1 ? 0 : 1; // 선택된 중앙수
                while (l > 0 && r <= n) {
                    if (state[l] == state[r]) {
                        state[l] = state[l] == 1 ? 0 : 1;
                        state[r] = state[r] == 1 ? 0 : 1;
                        l--;
                        r++;
                    } else break;
                }
            }
        }
    }
}
