import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 6443 애너그램
 Author: taeuk
 Date: 22-05-02
 */
public class Main {
    static int n;
    static char[] arr, res, tmp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
		    arr = br.readLine().toCharArray();
		    int length = arr.length; // 문자 길이
            res = new char[length];
            tmp = new char[length];
            visited = new boolean[length];

            Arrays.sort(arr); // 오름차순으로 출력

            dfs(0, length);
        }
        System.out.println(sb);
	}
	public static void dfs(int cnt, int length) {
	    if (length == cnt) {
	        sb.append(res).append("\n");
	        return;
        }

	    tmp[cnt] = 0;
	    for (int i = 0; i < length; i++) {
	        // 사용했거나, 앞자리 단어가 뒷자리 단어보다 작아야함 (중복)
	        if (visited[i] || arr[i] <= tmp[cnt]) continue;

            tmp[cnt] = arr[i];
	        visited[i] = true;
	        res[cnt] = arr[i];
	        dfs(cnt + 1, length);
	        visited[i] = false;
        }
    }
}
