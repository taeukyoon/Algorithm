import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 13022
 */
public class Main {
	static char[] wolf =  {'w', 'o', 'l', 'f'};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();

		System.out.println(process(str));
    }

	private static int process(String str) {
    	int[] cnt = new int[26];
    	char[] arr = new char[4];

    	// 첫번째
		cnt[str.charAt(0) - 'a']++;
		arr[0] = str.charAt(0);
		char prev = str.charAt(0);
		int idx = 1;

		for (int i = 1; i < str.length(); i++) {
			if (prev == str.charAt(i)) {
				cnt[str.charAt(i) - 'a']++;
				continue;
			}

			if (idx == 4) { // 4개가 순서맞나, 반복횟수
				if (!check(arr, cnt)) return 0;

				cnt = new int[26];
				idx = 0;
			}

			cnt[str.charAt(i) - 'a']++;
			prev = str.charAt(i);
			arr[idx++] = str.charAt(i);
		}

		if (!check(arr, cnt)) return 0;
		return 1;
	}

	private static boolean check(char[] arr, int[] cnt) {
    	int tmp = cnt[arr[0] - 'a'];
    	for (int i = 0; i < 4; i++) {
    		if (wolf[i] != arr[i]) return false; // wolf 순서
    		if (tmp != cnt[arr[i] - 'a']) return false;
		}
    	return true;
	}
}
