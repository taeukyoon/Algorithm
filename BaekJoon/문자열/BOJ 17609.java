import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOj 17609 회문
 Date: 22-05-16
 Author: taeuk
 */
public class Main {
	static int t;
	static char[] ch;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String str = br.readLine();
			ch = str.toCharArray();

			int left = 0;
			int right = str.length() - 1;

			// 회문
			if (checkStr(left, right)) {
				System.out.println(0);
				continue;
			}

			// 유사회문
			if (checkPesudo(left, right)) {
				System.out.println(1);
				continue;
			}
			System.out.println(2);
		}
	}

	private static boolean checkPesudo(int left, int right) {
		while (left <= right) {
			if (ch[left] != ch[right]) {
				boolean a = checkStr(left + 1, right);
				boolean b = checkStr(left, right - 1);

				if (!a && !b) {
					return false;
				}
				return true;
			}
			left++;
			right--;
		}
		return true;
	}

	private static boolean checkStr(int left, int right) {
		while (left <= right) {
			if (ch[left] != ch[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
