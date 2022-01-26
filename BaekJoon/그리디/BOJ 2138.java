import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 BOJ 2138 전구와 스위치
 */
public class Main {
    static int n, res = Integer.MAX_VALUE;
    static boolean[] arr1, arr2, b;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr1 = new boolean[n]; // 맨앞을 켰을때
        arr2 = new boolean[n];
        b = new boolean[n];

        char[] ch;
        ch = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            arr1[i] = ch[i] == '1';
            arr2[i] = ch[i] == '1';
        }

        ch = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            b[i] = ch[i] == '1';
        }

        process(arr1, 0); // 1번째 스위치 온

        int cnt1 = 1, cnt2 = 0;
        for (int i = 1; i < n; i++) {
            if (arr1[i - 1] != b[i - 1]) {
                cnt1++;
                process(arr1, i);
            }
            if (arr2[i - 1] != b[i - 1]) {
                cnt2++;
                process(arr2, i);
            }
        }
        res = check(cnt1, cnt2);
        System.out.println((res == Integer.MAX_VALUE) ? -1 : res);
    }
    public static void process(boolean[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < n) {
                arr[i] = !arr[i];
            }
        }
    }
    public static int check(int cnt1, int cnt2) {
        boolean check1 = true;
        boolean check2 = true;

        for (int i = 0; i < n; i++) {
            if (arr1[i] != b[i]) {
                check1 = false;
            }
            if (arr2[i] != b[i]) {
                check2 = false;
            }
        }
        if (check1) res = cnt1;
        if (check2) res = Math.min(res, cnt2);

        return res;
    }
}
