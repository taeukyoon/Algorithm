import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 5212 지구 온난화
 Date: 22-07-22
 Author: taeuk
 */
public class Main {
	static int r, c;
	static char[][] map, afterMap;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		afterMap = new char[r][c];

		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int minR = 10, minC = 10;
		int maxR = 0, maxC = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'X') {
					int seaCnt = 0;
					for (int k = 0; k < 4; k++) {
						int nr = i + dx[k];
						int nc = j + dy[k];

						if (nr < 0 || nc < 0 || nr >= r || nc >= c || map[nr][nc] == '.')
							seaCnt++;
					}

					if (seaCnt < 3) {
						afterMap[i][j] = 'X';

						minR = Math.min(minR, i);
						minC = Math.min(minC, j);
						maxR = Math.max(maxR, i);
						maxC = Math.max(maxC, j);
					} else {
						afterMap[i][j] = '.';
					}
				} else
					afterMap[i][j] = '.';
			}
		}

		for (int i = minR; i <= maxR; i++) {
			for (int j = minC; j <= maxC; j++) {
				System.out.print(afterMap[i][j]);
			}
			System.out.println();
		}
	}
}
