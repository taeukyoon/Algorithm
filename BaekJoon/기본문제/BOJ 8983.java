import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 8983 사냥꾼
 */
public class Main {
    static int m, n, l;
    static int[] pos;
    static Animal[] animals;

    static class Animal {
        int x, y;

        public Animal(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        pos = new int[m];
        animals = new Animal[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            animals[i] = new Animal(x, y);
        }
        System.out.println(process());
    }
    public static int process() {
        int res = 0;
        Arrays.sort(pos);

        for (int i = 0; i < n; i++) {
            res += binarySearch(i);
        }
        return res;
    }
    public static int binarySearch(int idx) {
        int s = 0, e = m, mid = 0;

        while (s <= e) {
            mid = (s + e) / 2;

            if (mid >= m) return 0;
            int dist = Math.abs(pos[mid] - animals[idx].x) + animals[idx].y;

            if (l < dist && animals[idx].x < pos[mid]) e = mid - 1;
            else if (l < dist && animals[idx].x >= pos[mid]) s = mid + 1;
            else if (l >= dist) return 1;
        }
        return 0;
    }
}
