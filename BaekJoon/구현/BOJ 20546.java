import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 20543 🐜 기적의 매매법 🐜
 */
public class Main {
    static class Stock {
        int cost;
        int cnt;

        public Stock(int cost, int cnt) {
            this.cost = cost;
            this.cnt = cnt;
        }

        void buyStock(int cost, int cnt) {
            if (this.cost < cost * cnt) return;
            this.cnt += cnt;
            this.cost -= cost * cnt;
        }

        void sellStock(int cost) {
            this.cost += cost * this.cnt;
            this.cnt = 0;
        }
    }
    static int money;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        money = Integer.parseInt(br.readLine());
        arr = new int[14];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = junHyun();
        int s = sungMin();

        if (j > s) System.out.println("BNP");
        else if (j < s) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
    public static int junHyun() {
        Stock stock = new Stock(money, 0);
        for (int i : arr) {
            int cash = stock.cost;
            int cnt = cash / i;

            if (cnt > 0) {
                stock.buyStock(i, cnt);
            }
        }
        int res = stock.cost + (stock.cnt * arr[13]);
        return res;
    }

    public static int sungMin() {
        Stock stock = new Stock(money, 0);
        for (int i = 3; i < 14; i++) {
            int cash = arr[i];
            int cnt = money / cash;

            if (arr[i - 1] > arr[i - 2] && arr[i - 2] > arr[i - 3]) {
                stock.sellStock(cash);
            } else if (arr[i - 1] < arr[i - 2] && arr[i - 2] < arr[i - 3]) {
                stock.buyStock(cash, cnt);
            }
        }
        int res = stock.cost + (stock.cnt * arr[13]);
        return res;
    }
}
