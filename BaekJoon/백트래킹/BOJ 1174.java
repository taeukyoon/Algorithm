import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 BOJ 1174 줄어드는 수
 Author: taeuk
 Date: 22-04-27
 */
public class Main {
	static int n;
	static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		dfs(0, 0);

		Collections.sort(list);

		// 10개의 숫자를 선택하고 안하고의 두 가지 선택은 2 ^ 10의 1024의 경우의수가 나온다.
		// 1024의 범위를 넘어서면 -1을 출력
		if (n > 1023) {
			System.out.println(-1);
		} else {
			System.out.println(list.get(n - 1));
		}

	}

	public static void dfs(long sum, int idx) {
		// sum이 그전까지 나오지않은 숫자면 리스트에 추가
		if (!list.contains(sum)) {
			list.add(sum);
		}
		// num 배열 탐색완료
		if (idx >= 10) {
			return;
		}
		// 숫자 선택, 선택안한거
		dfs(sum * 10 + num[idx], idx + 1);
		dfs(sum, idx + 1);
	}
}
