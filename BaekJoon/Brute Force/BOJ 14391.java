import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 14391 종이 조각
 Date: 22-08-03
 Author: taeuk
 */
public class Main {
	static int n, m, max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
        	String str = br.readLine();
        	for (int j = 0; j < m; j++) {
        		map[i][j] = str.charAt(j) - '0';
			}
		}

        dfs(0, 0);
		System.out.println(max);
    }

	private static void dfs(int r, int c) {
    	if (r >= n) {
    		sum();
    		return;
		}

    	if (c >= m) {
    		dfs(r + 1, 0);
    		return;
		}

    	visited[r][c] = true;
    	dfs(r, c + 1);
    	visited[r][c] = false;
    	dfs(r, c + 1);
	}

	private static void sum() {
		int res = 0;
    	int temp = 0;

    	// 가로
    	for (int i = 0; i < n; i++) {
    		temp = 0;
    		for (int j = 0; j < m; j++) {
    			if (visited[i][j]) {
    				temp *= 10;
    				temp += map[i][j];
    				continue;
				}
    			res += temp;
    			temp = 0;
			}
    		res += temp;
		}

    	// 세로
		for (int i = 0; i < m; i++) {
			temp = 0;
			for (int j = 0; j < n; j++) {
				if (!visited[j][i]) {
					temp *= 10;
					temp += map[j][i];
					continue;
				}
				res += temp;
				temp = 0;
			}
			res += temp;
		}

		max = Math.max(max, res);
	}
}
