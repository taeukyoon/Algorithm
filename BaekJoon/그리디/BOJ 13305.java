import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 13305 주유소
 Greedy
 */
public class Main {
    static int n;
    static int[] distance;
    static int[] fuel;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        distance = new int[n-1];
        fuel = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < fuel.length; i++) {
            fuel[i] = Integer.parseInt(st.nextToken());
        }

        long res = 0;
        long min = fuel[0];

        for (int i = 0; i < distance.length; i++) {
            if (fuel[i] < min) {
                min = fuel[i];
            }

            res += min * distance[i];
        }
        System.out.println(res);
    }
}
