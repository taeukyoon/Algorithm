import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 19637 IF문 좀 대신 써줘
 Binary Search
 */
public class Main {
    static int n, m;
    static ArrayList<Type> types;

    static class Type {
        String title;
        int power;

        public Type(String title, int power) {
            this.title = title;
            this.power = power;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        types = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            types.add(new Type(title, power));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int combatPower = Integer.parseInt(br.readLine());
            String res = binarySearch(combatPower);
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    public static String binarySearch(int power) {
        int left = 0, right = types.size();

        while (left <= right) {
            int mid = (left + right) / 2;
            int selectPower = types.get(mid).power;

            if (power > selectPower) left = mid + 1;
            else right = mid - 1;
        }
        return types.get(left).title;
    }
}
