import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 16918 봄버맨
 Date: 22-06-22
 Author: taeuk
 */
public class Main {
	static int r, c, n;
	static char[][] map;
	static int[][] num;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		num = new int[r][c];

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'O') {
					num[i][j] = 3;
				}
			}
		}

		int time = 1;
		while (time < n) {
			time++; // 1초간은 행동x
			install(time); // 빈곳에 폭탄 설치
			if (time == n) break;
			time++;
			boom(time);
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void boom(int time) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (num[i][j] == time) {
					map[i][j] = '.';

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
						map[nx][ny] = '.';
					}
				}
			}
		}
	}

	private static void install(int time) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
					num[i][j] = 3 + time; // 폭팔 시간
				}
			}
		}
	}
}
