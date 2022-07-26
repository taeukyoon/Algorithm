import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 10448 유레카 이론
 Date: 22-07-26
 Author: taeuk
 */
public class Main {
	static int t;
	static boolean flag;
	static int[] num = new int[45];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        // 삼각수
        for (int i = 1; i < num.length; i++) {
        	num[i] = i * (i + 1) / 2;
		}

        while (t-- > 0) {
        	int k = Integer.parseInt(br.readLine());

        	flag = false;
        	recursion(k, 0);

        	if (flag) {
				System.out.println(1);
			} else
				System.out.println(0);
		}
    }

	private static void recursion(int k, int cnt) {
    	if (cnt == 3) {
    		if (k == 0) {
    			flag = true;
			}
    		return;
		}

		for (int i = 1; i < num.length; i++) {
			if (num[i] > k) return;
			recursion(k - num[i], cnt + 1);
		}
	}
}
