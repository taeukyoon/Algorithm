import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 14400
 */
public class Main {
    static int n;
    static class Customer {
        int x, y;

        public Customer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        Customer[] customers = new Customer[n];
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr1[i] = x;
            arr2[i] = y;
            customers[i] = new Customer(x, y);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int x = arr1[n / 2];
        int y = arr2[n / 2];

        long res = 0;
        for (int i = 0; i < customers.length; i++) {
            res += Math.abs(customers[i].x - x) + Math.abs(customers[i].y - y);
        }
        System.out.println(res);
    }
}
