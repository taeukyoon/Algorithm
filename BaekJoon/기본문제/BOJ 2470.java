import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 2470 두 용액
 */
public class Main {
    static int n, res;
    static int[] liquid;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        liquid = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquid);

        int left = 0, right = liquid.length - 1, min = Integer.MAX_VALUE;
        int liquid1 = 0, liquid2 = 0;
        while (left < right) {
            int sum = liquid[left] + liquid[right];
            int res = Math.abs(sum); // 절대값

            if (res < min) {
                min = res;
                liquid1 = liquid[left];
                liquid2 = liquid[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(liquid1+" "+liquid2);
    }
}
