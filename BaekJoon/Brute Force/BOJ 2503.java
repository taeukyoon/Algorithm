import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
 BOJ 2503 숫자 야구
 Date: 22-07-27
 Author: taeuk
 */
public class Main {
	static int n, res;
	static ArrayList<Baseball> list;

	static class Baseball {
		int val, s, b;

		public Baseball(int val, int s, int b) {
			this.val = val;
			this.s = s;
			this.b = b;
		}
	}
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int val = Integer.parseInt(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.add(new Baseball(val, s, b));
		}

        game();
		System.out.println(res);
    }

	private static void game() {

		for (int i = 123; i <= 987; i++) {
			if (!checkDuplicate(i)) continue;

			int pass = 0;

			for (int a = 0; a < n; a++) {
				int strike = 0;
				int ball = 0;

				Baseball b = list.get(a);
				String currentVal = String.valueOf(b.val);
				String compareVal = String.valueOf(i);


				for (int k = 0; k < 3; k++) {
					if (currentVal.charAt(k) == compareVal.charAt(k)) {
						strike++;
					}
				}

				for (int k = 0; k < 3; k++) {
					for (int c = 0; c < 3; c++) {
						if (currentVal.charAt(k) == compareVal.charAt(c)) {
							if (k != c) ball++;
						}
					}
				}

				if (b.s == strike && b.b == ball) {
					pass++;
				}
			}

			if (pass == n) {
				res++;
			}
		}
	}

	private static boolean checkDuplicate(int i) {
		String val = String.valueOf(i);

		if (val.charAt(0) == val.charAt(1))  return false;
		if (val.charAt(0) == val.charAt(2))  return false;
		if (val.charAt(1) == val.charAt(2))  return false;

		if (val.charAt(0) == '0' || val.charAt(1) == '0' || val.charAt(2) == '0') return false;

		return true;
	}
}
