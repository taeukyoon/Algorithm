import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 BOJ 13164 행복 유치원
 */
public class Main {
    static int n, k;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n - 1; i++) {
            list.add(al.get(i + 1) - al.get(i));
        }
        Collections.sort(list);

        int res = 0;
        for (int i = 0; i < n-k; i++) {
            res += list.get(i);
        }
        System.out.println(res);
    }
}
