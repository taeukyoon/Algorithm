import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 16719 ZOAC
 */
public class Main {
    static String str;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        visited = new boolean[str.length()];

        output(0, str.length() - 1);
    }

    public static void output(int left, int right) {

        if (left > right) return;
        int idx = left;
        for (int i = left; i <= right; i++) { // 사전순서 찾기
            if (str.charAt(idx) > str.charAt(i)) {
                idx = i;
            }
        }
        visited[idx] = true;

        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                System.out.print(str.charAt(i));
            }
        }
        System.out.println();

        output(idx + 1, right); //오른쪽 범위
        output(left, idx - 1);
    }
}
