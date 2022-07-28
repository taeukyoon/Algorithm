import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 2422
 Date: 22-07-28
 Author: taeuk
 */
public class Main {
	static int n, m, res;
	static int[][] arr;
	static boolean[] visited;
	static int[] val = new int[3];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visited = new boolean[n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		perm(0, 0);
		System.out.println(res);
	}

	private static void perm(int idx, int cnt) {
		if (cnt == 3) {
			if (check()) {
				res++;
			}
			return;
		}

		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				val[cnt] = i;
				perm(i, cnt + 1);
				visited[i] = false;
			}
		}
	}

	private static boolean check() {
    	for (int i = 0; i < 2; i++) {
    		for (int j = i + 1; j < 3; j++) {
    			if (arr[val[i]][val[j]] == 1) return false;
			}
		}
    	return true;
	}
}
