import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 9094 수학적 호기심
 Date: 22-08-03
 Author: taeuk
 */
public class Main {
	static int t, n, m;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	st = new StringTokenizer(br.readLine(), " ");
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());

        	int result = 0;
        	for (int a = 1; a < n; a++) {
        		for (int b = a + 1; b < n; b++) {
        			if (((a * a) + (b * b) + m) % (a * b) == 0) {
        				result++;
					}
				}
			}
			System.out.println(result);
		}
    }
}
