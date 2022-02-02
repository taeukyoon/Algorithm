import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 18113 그르다 김가놈
 이분탐색
 */
public class Main {
    static int n, k, m;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val - 2*k > 0) {
                list.add(val - (2*k));
            }
            if (val - 2*k < 0 && val - k > 0) {
                list.add(val-k);
            }
        }
        int s = 1, e = 1000000000;
        int res = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = cal(list, mid);

            if (cnt >= m) {
                res = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println((res > 0) ? res : -1);
    }
    public static int cal(ArrayList<Integer> list, int mid) {
        int cnt = 0;
        for (Integer i : list) {
            cnt += i / mid;
        }
        return cnt;
    }
}
