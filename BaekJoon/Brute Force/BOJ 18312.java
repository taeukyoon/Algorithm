import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 18312 시각
 Date: 22-07-27
 Author: taeuk
 */
public class Main {
	static int n, k;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int h = 0; h <= n; h++) {
        	for (int m = 0; m < 60; m++) {
        		for (int s = 0; s < 60; s++) {
        			if (check(h, m, s)) cnt++;
				}
			}
		}
		System.out.println(cnt);
    }

	private static boolean check(int h, int m, int s) {

    	if (h / 10 == k || h % 10 == k || m / 10 == k || m % 10 == k || s / 10 == k || s % 10 == k) {
    		return true;
		}
    	return false;
	}
}
