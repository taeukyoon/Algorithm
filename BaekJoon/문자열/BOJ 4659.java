import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 4659 비밀번호 발음하기
 Date: 22-05-15
 Author: tauek
 */
public class Main {
	static char[] vowel = {'a', 'e', 'i', 'o', 'u'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String testCase = br.readLine();
			if (testCase.equals("end"))
				break; // 종료조건

			sb.append("<").append(testCase).append("> is ");
			if (!checkHighQuality(testCase)) {
				sb.append("not ");
			}
			sb.append("acceptable.").append("\n");
		}
		System.out.println(sb);
	}

	private static boolean checkHighQuality(String testCase) {

		// 모음체크
		if (haveMo(testCase))
			return false;

		// 3개연속 자음, 모음체크
		if (validThree(testCase))
			return false;

		// 같은글자 연속 2번 체크 (ee,oo)예외
		if (validDuplicate(testCase))
			return false;

		return true;
	}

	private static boolean validDuplicate(String testCase) {
		for (int i = 1; i < testCase.length(); i++) {
			if (testCase.charAt(i) == testCase.charAt(i - 1)) {
				if (testCase.charAt(i) != 'e' && testCase.charAt(i) != 'o') {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean validThree(String testCase) {
		for (int i = 2; i < testCase.length(); i++) {
			char[] arr = testCase.toCharArray();
			if (isMo(arr[i])) {  // 모음
				if (isMo(arr[i - 1]) && isMo(arr[i - 2])) { // 3개 모음
					return true;
				}
				break;
			}
			if (!isMo(arr[i - 1]) && !isMo(arr[i - 2])) { // 3개 자음
				return true;
			}

		}
		return false;
	}

	private static boolean isMo(char c) {
		for (char v : vowel) {
			if (v == c)
				return true;
		}
		return false;
	}

	private static boolean haveMo(String testCase) {
		for (int i = 0; i < testCase.length(); i++) {
			char c = testCase.charAt(i);
			for (char value : vowel) {
				if (c == value) {
					return false;
				}
			}
		}
		return true;
	}
}

